package io.dzh.netty.k_io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Do
 * @description 一个相对完整的nio 服务器客户端demo，服务端使用一个线程，一个 SocketChannel 来处理多个客户端的连接
 *              接受到一个客户端的消息，并转发给其他客户端
 * @date 2019-04-09 18:20
 */
public class NioDemoServer {
    private static Map<String, SocketChannel> clientMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        // 服务器创建一个 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 通过 服务器的 serverSocketChannel 获取 ServerSocket
        ServerSocket serverSocket = serverSocketChannel.socket();
        // 绑定
        serverSocket.bind(new InetSocketAddress(8899));

        // 创建一个选择器对象
        Selector selector = Selector.open();

        // 将服务器的 ServerSocketChannel 注册到 selector中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        /*  注册完成, 开始事件的处理  */

        while (true) {
            try {
                // 调用 selector 的 select 方法进行阻塞
                // 等待他所关注的事件发生, 返回他所关注事件的数量
                int select = selector.select();

                // 获取他所关注的事件的 selectorKey 集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                // 根据事件类型做出不同处理
                selectionKeys.forEach(selectionKey ->{
                    // 客户端channel
                    final SocketChannel clientChannel;
                    Channel channel =  selectionKey.channel();
                    try {

                        // 判断是否是接受事件
                        if (selectionKey.isAcceptable()) {
                            // 返回 ServerSocketChannel 的原因 因为 OP_ACCEPT 事件只注册了 ServerSocketChannel
                            ServerSocketChannel serverChannel = (ServerSocketChannel) channel;
                            // 与客户端简历连接
                            clientChannel = serverChannel.accept();
                            System.out.println("clent: " + clientChannel.getRemoteAddress() + "连接");
                            // 非阻塞
                            clientChannel.configureBlocking(false);
                            // 注册客户端的channel 可读事件
                            clientChannel.register(selector, SelectionKey.OP_READ);
                            // 保存客户端 channel 后续推送消息
                            String key = UUID.randomUUID().toString().replace("-", "");

                            clientMap.put(key, clientChannel);

//                            // 事件消费完, 从set中移除
//                            selectionKeys.remove();

                         // 判断是否是 有数据可读
                        } else if (selectionKey.isReadable()) {
                            // 获取客户端channel socketChannel
                            clientChannel = (SocketChannel) channel;
                            // 准备 buffer对象
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            int byteRead = 0;
                            // 将操作系统穿来的数据,读到buffer中
                            int read = clientChannel.read(byteBuffer);

                            if (read > 0) {
                                // 翻转
                                byteBuffer.flip();

                                // 将字节转换字符串
                                Charset charset = Charset.forName("utf-8");
                                String receiveMessage = String.valueOf(charset.decode(byteBuffer).array());
                                System.out.println(clientChannel.getRemoteAddress() + " 的消息:"+receiveMessage);

                                // 分发给其他客户端
                                // 通过clientChannel 找出key
                                String senderKey = null;
                                for (Map.Entry<String,SocketChannel> entry : clientMap.entrySet()) {
                                    if (clientChannel == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }
                                for (Map.Entry<String,SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put((senderKey  + ": " + receiveMessage).getBytes());
                                    writeBuffer.flip();
                                    value.write(writeBuffer);
                                }

                                // 发送给其他客户端
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();

                    }


                });

                // 清除已处理事件
                selectionKeys.clear();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

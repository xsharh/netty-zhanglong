package io.dzh.netty.k_io.nio.selector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Do
 * @description  这是一个client
 * @date 2019-04-09 18:20
 */
public class NioDemoClient {
    private static Map<String, SocketChannel> clientMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        // 客户端创建一个 SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞
        socketChannel.configureBlocking(false);
        // 创建一个选择器对象
        Selector selector = Selector.open();
        // 注册客户端的连接事件 socketChannel
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        // 连接
        socketChannel.connect(new InetSocketAddress("localhost", 8899));



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

                        // 判断是否是连接事件
                        if (selectionKey.isConnectable()) {
                            // 返回 ServerSocketChannel 的原因 因为 OP_ACCEPT 事件只注册了 ServerSocketChannel
                            clientChannel = (SocketChannel) channel;
                            // 是否等待连接,完成连接
                            if (clientChannel.isConnectionPending()) {
                                clientChannel.finishConnect();
                                System.out.println("您已连接服务器...");

                                // 发数据到服务器
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());// 读
                                writeBuffer.flip();
                                clientChannel.write(writeBuffer);// 写

                                // 建立线程,监控键盘输入
                                // 创建一个单线程线程池
                                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                // 提交线程
                                executorService.submit(()->{
                                    while (true) {
                                        writeBuffer.clear();
                                        InputStreamReader in = new InputStreamReader(System.in);
                                        BufferedReader bufferedReader = new BufferedReader(in);

                                        String line = bufferedReader.readLine();
                                        writeBuffer.put(line.getBytes());
                                        writeBuffer.flip();
                                        clientChannel.write(writeBuffer);

                                    }
                                });
                            }
                            // 注册读取事件
                            clientChannel.register(selector, SelectionKey.OP_READ);

                        } else if (selectionKey.isReadable()) {
                            clientChannel = (SocketChannel) channel;
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
//                            int byteRead = 0;
                            int read = clientChannel.read(readBuffer);
                            if (read > 0 ) {
                                String receivedMessage = new String(readBuffer.array(), 0, read);
                                System.out.println(receivedMessage);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                // 清空已处理的事件
                selectionKeys.clear();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

package io.dzh.netty.k_io.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Do
 * @description 使用 linux  nc 192.168.238.1 50000 测试
 *              nio 基本网络模型
 * @date 2019-04-09 14:49
 */
public class NioSelector {
    public static void main(String[] args) throws IOException {

        // 一个线程监听 5 个端口的事件, 注册 5 个 ServerSocketChannel 到 selector 中
        int[] ports = new int[5];
        ports[0] = 50000;
        ports[1] = 50001;
        ports[2] = 50002;
        ports[3] = 50003;
        ports[4] = 50005;

        Selector selector = Selector.open();

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置为非阻塞的selector
            serverSocketChannel.configureBlocking(false);

            // 监听数组中的宽口==端口
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(address);

            // 将selector serverSocketChannel, 注册类型为 接受类型, 返回selectionKey
            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.printf("监听端口: %s", ports[i]);
        }

        while (true) {
            // 返回key 的数量
            int select = selector.select();
            System.out.println("keys number: " + select);

            // 获取 selection keys
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys" + selectionKeys);
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            // 迭代
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                // 是否有连接
                if (key.isAcceptable()) {

                    // 获取channel
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();

                    //非阻塞 等待连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);

                    SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);

                    // 事件消费完, 从set中移除
                    iterator.remove();

                    System.out.println("获取到客户端连接: " + socketChannel);

                } else if (key.isReadable()) {

                    /*
                    * selector channel buffer 的关系
                    * */

                    SocketChannel SocketChannel = (SocketChannel) key.channel();


                    int byteRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(521);
                        byteBuffer.clear();
                        int read = SocketChannel.read(byteBuffer);

                        if (read <= 0) {
                            break;
                        }

                        byteBuffer.flip();

                        SocketChannel.write(byteBuffer);
                        byteRead += read;

                    }
                    System.out.println("读取 " + byteRead + "个字节, 来自于 " + SocketChannel.getRemoteAddress());
                    iterator.remove();


                }
            }
        }
    }
}

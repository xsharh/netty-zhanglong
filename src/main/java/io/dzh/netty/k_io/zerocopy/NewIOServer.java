package io.dzh.netty.k_io.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Do
 * @description
 * @date 2019-04-10 18:45
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {

            // 客户端连接, 返回一个阻塞的 socket
            SocketChannel socketChannel = serverSocketChannel.accept();
            // 如果使用selector 则设置为非阻塞
            // socketChannel.configureBlocking(false);
             socketChannel.configureBlocking(true); // 不设置也是阻塞的

            // 记录读的字节
            long readCount = 0;
            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);
                    byteBuffer.flip();

                }catch (Exception e){
                    e.getStackTrace();
                }
                byteBuffer.rewind();
            }

        }
    }

}

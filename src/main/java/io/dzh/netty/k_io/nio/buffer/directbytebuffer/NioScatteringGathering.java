package io.dzh.netty.k_io.nio.buffer.directbytebuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author Do
 * @description Scattering 与 Gathering 分散与收集
 *              Scattering 一般用于自定义协议 将channel中的多个字节，指定长度的读到多个buffer中
 * @date 2019-04-09 11:17
 */
public class NioScatteringGathering {
    public static void main(String[] args) throws IOException {
        // 定义服务器, 绑定8899端口
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        socketChannel.socket().bind(address);

        // 构造三个buffer
        int messageLength = 2+3+4;

        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel channel = socketChannel.accept();
        System.out.printf("客户端: %s 连接了", channel.getRemoteAddress());

        // buffers 读取
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long r = channel.read(buffers);
                byteRead += r;
                System.out.println("byteRead:\t" + byteRead);
                // 将每个buffer打印出来
                Arrays.asList(buffers).stream().map(buffer ->
                        "position: " + buffer.position() + "\n" +
                                "limit: " + buffer.limit() + "\n"
                ).forEach(System.out::println);

            }
                // 翻转每个buffer
                Arrays.asList(buffers).forEach(buffer -> buffer.flip());

                // buffer 写出
                long byteWritten = 0;
                while (byteWritten < messageLength) {
                    long w = channel.write(buffers);
                    byteWritten += w;
                }

                // 重置buffer
                Arrays.asList(buffers).forEach(buffer -> buffer.clear());
                System.out.printf("byteRead: %s\nbyteWritten: %s\nmessageLength: %s\n", byteRead, byteWritten, messageLength);
            }

    }
}

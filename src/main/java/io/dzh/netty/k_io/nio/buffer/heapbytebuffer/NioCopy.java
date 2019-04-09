package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Do
 * @description nio 完成copy
 * @date 2019-04-08 21:19
 */
public class NioCopy {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("input.txt");
        OutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = ((FileInputStream) inputStream).getChannel();
        FileChannel outputChanel = ((FileOutputStream) outputStream).getChannel();

        // position 初始值为0, limit 初始值为 1024, capacity 1024
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            // 初始化 position, limit
            byteBuffer.clear();
            // 位移 position的值, 相对读方法, 会先判断position的值与limit的值,相等返回0,
            //                                                      不相等在判断byteBuffer的值，空的返回-1
            int read = inputChannel.read(byteBuffer);
            if (-1 == read) {
                break;
            }
            // 翻转, limit = position, 初始化position的值
            byteBuffer.flip();
            // 位移 position 直到与limit相等
            outputChanel.write(byteBuffer);
        }

        inputStream.close();
        outputStream.close();

    }
}

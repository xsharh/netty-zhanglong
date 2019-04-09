package io.dzh.netty.k_io.nio.buffer.directbytebuffer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Do
 * @description allocateDirect 生成直接缓冲
 * @date 2019-04-08 21:19
 */
public class NioCopyAllocateDirect {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("input.txt");
        OutputStream outputStream = new FileOutputStream("output2.txt");

        FileChannel inputChannel = ((FileInputStream) inputStream).getChannel();
        FileChannel outputChanel = ((FileOutputStream) outputStream).getChannel();

        // position 初始值为0, limit 初始值为 1024, capacity 1024
//        ByteBuffer.wrap(); 将一个byte数组转化为buffer
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

    }
}

package io.dzh.netty.k_io.nio.buffer.directbytebuffer;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Do
 * @description 操作内存映射来操作文件
 * @date 2019-04-08 21:19
 */
public class NioCopyAllocateDirect2 {
    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("NioMappedByteBuffer.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'j');
        mappedByteBuffer.put(3, (byte) 'k');

        randomAccessFile.close();


    }

}

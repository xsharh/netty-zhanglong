package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Do
 * @description 使用nio 读取文件
 * @date 2019-04-08 11:32
 */
public class NioTest2Read {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(521);
        channel.read(buffer);

        buffer.flip();

        while (buffer.capacity()>0){
            byte b = buffer.get();
            System.out.println("Character" + (char)b);
        }

        fileInputStream.close();
    }

}

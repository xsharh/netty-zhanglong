package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Do
 * @description 使用nio 写入文件
 * @date 2019-04-08 11:32
 */
public class NioTest2Writer {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();

        // position 初始值为0, limit 初始值为 521, capacity 初始值为521
        ByteBuffer buffer = ByteBuffer.allocate(521);
        byte[] message = "hello world welcome nio".getBytes();

        for (int i = 0; i < message.length; i++) {
            buffer.put(message[i]);

        }
        buffer.flip();
        channel.write(buffer);

        fileOutputStream.close();
    }

}

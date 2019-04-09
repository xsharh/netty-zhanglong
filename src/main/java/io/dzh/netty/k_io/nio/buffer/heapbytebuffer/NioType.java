package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.nio.ByteBuffer;

/**
 * @author Do
 * @description buffer 中放置/取出不同类型地数据类型
 * @date 2019-04-09 07:25
 */
public class NioType {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put((byte) 2);
        buffer.put((byte) 1);
        buffer.putInt(100);
        buffer.putShort((short)133);
        buffer.putDouble(0.1112313);
        buffer.putChar('号');
        buffer.putLong(1112121231);
        buffer.putFloat(0.12f);

        buffer.flip();

        System.out.println(buffer.get());
        System.out.println(buffer.get());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getFloat());

    }
}

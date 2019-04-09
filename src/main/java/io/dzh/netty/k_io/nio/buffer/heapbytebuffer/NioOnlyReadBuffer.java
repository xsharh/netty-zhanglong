package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.nio.ByteBuffer;

/**
 * @author Do
 * @description 生出一个只读buffer
 * @date 2019-04-09 08:15
 */
public class NioOnlyReadBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
    }
}

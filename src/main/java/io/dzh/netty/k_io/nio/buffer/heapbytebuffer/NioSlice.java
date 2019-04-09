package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.nio.ByteBuffer;

/**
 * @author Do
 * @description slice buffer 分割, 左闭右开,
 *              切割后的buffer与原来的buffer使用同一份引用(共享同一个底层数组),数据同步
 * @date 2019-04-09 07:40
 */
class NioSlice {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        buffer.position(2);
        buffer.limit(10);
        ByteBuffer sliceBuffer = buffer.slice();

        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            b *= 2;
            sliceBuffer.put(i, b);
        }

        buffer.clear();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }
}

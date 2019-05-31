package io.dzh.netty.l_netty_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Iterator;

/**
 * @author Do
 * @description netty 的三种缓冲区-复合缓冲区
 * @date 2019-05-28 10:44
 */
public class CompositeBuffer {
    public static void main(String[] args) {
        // 创建一个符合缓冲区添加间接缓冲与直接缓冲
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        ByteBuf heepBuf = Unpooled.buffer(10);
        ByteBuf directBuffer = Unpooled.directBuffer(8);
        compositeByteBuf.addComponents(heepBuf, directBuffer);
        compositeByteBuf.removeComponent(0);
        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();
        while (iterator.hasNext()) {
            ByteBuf next = iterator.next();
            System.out.println(next);
        }
        compositeByteBuf.forEach(System.out::println);


    }
}

package io.dzh.netty.l_netty_bytebuf;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;


/**
 * @author Do
 * @description
 * @date 2019-05-28 09:14
 */
public class ByteBufTest {

    public static void main(String[] args) {
        ByteBuf bytebuf = Unpooled.copiedBuffer("张hello world", Charset.forName("utf-8"));
        if (bytebuf.hasArray()){
            byte[] array = bytebuf.array();

            System.out.println(new String(array, Charset.forName("utf-8")));

            System.out.println(bytebuf);
            for (int i = 0; i < bytebuf.capacity(); i++) {
                System.out.println((char) bytebuf.getByte(i));
            }
            System.out.println(bytebuf.getCharSequence(0, 4, Charset.forName("utf-8")));
            System.out.println(bytebuf.getCharSequence(4, 6, Charset.forName("utf-8")));
        }
    }



}

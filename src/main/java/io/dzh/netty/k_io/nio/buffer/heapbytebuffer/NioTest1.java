package io.dzh.netty.k_io.nio.buffer.heapbytebuffer;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author Do
 * @description 引出NIO例子
 * @date 2019-04-08 10:00
 */
public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        System.out.println("capacity:\t" + buffer.capacity()); //10

//        for (int i = 0; i < buffer.capacity(); ++i) {
        for (int i = 0; i < 5; ++i) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        System.out.println("before flip limit:\t" + buffer.limit()); //10
        // 翻转
        buffer.flip();
        System.out.println("after flip limit:\t" + buffer.limit()); //5
        System.out.println(" Enter While loop");
        while (buffer.hasRemaining()){
            System.out.println("position:\t" + buffer.position()); //0.1.2.3.4
            System.out.println("limit:\t" + buffer.limit()); //5.5.5.5.5
            System.out.println("capacity:\t" + buffer.capacity()); //10.10.10.10.10
            System.out.println(buffer.get());
        }
    }
}

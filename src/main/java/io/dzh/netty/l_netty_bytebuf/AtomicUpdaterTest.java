package io.dzh.netty.l_netty_bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Do
 * @description
 * @date 2019-05-28 14:49
 */
class AtomicUpdaterTest{
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Person> integerFieldUpdater = AtomicIntegerFieldUpdater.
                newUpdater(Person.class,"age");

        Person person = new Person();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(integerFieldUpdater.getAndIncrement(person));
            }).start();

        }
    }
}
 class Person {
    volatile int age = 1;
}

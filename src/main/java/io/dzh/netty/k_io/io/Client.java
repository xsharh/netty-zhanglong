package io.dzh.netty.k_io.io;

/**
 * 客户端代码
 */
public class Client {

    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
        /*运行输出结果：
        具体对象的操作
        具体装饰对象A的操作。New State
        我是具体装饰对象B的独有方法
        具体装饰对象B的操作
        */
    }


}

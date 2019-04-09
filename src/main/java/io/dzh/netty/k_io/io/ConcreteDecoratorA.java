package io.dzh.netty.k_io.io;


/**
 * 具体装饰角色A
 */
public class ConcreteDecoratorA extends Decorator {
    //本类的独有功能
    private String addedState;
    //首先运行原Component的operation()，再执行本类的功能，相当于对原Component进行了装饰
    @Override
    public void operation(){
        super.operation();
        addedState = "New State";
        System.out.println("具体装饰对象A的操作。" + addedState);
    }
}


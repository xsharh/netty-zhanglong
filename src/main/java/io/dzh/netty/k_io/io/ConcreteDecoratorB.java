package io.dzh.netty.k_io.io;


/**
 * 具体装饰角色B
 */
public class ConcreteDecoratorB extends Decorator {
    //首先运行原Component的operation()，再执行本类的功能，相当于对原Component进行了装饰
    @Override
    public void operation() {
        super.operation();
        AddedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    //本类的独有功能
    private void AddedBehavior() {
        System.out.println("我是具体装饰对象B的独有方法");
    }
}
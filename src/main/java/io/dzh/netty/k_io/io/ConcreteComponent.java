package io.dzh.netty.k_io.io;


/**
 * 具体构件角色
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}

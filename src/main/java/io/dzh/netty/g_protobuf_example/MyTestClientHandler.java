package io.dzh.netty.g_protobuf_example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author Do
 * @description  将 MyDataInfo.Person 改造成枚举类型MyMessge 方便支持多种类型的传输
 * @date 2019-02-20 20:13
 */
public class MyTestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    /**
     * 连接处于活动状态,客户端向服务器发送请求
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().
//                setName("张三").setAge(18).setAddress("江西").build();
        MyDataInfo.MyMessage message = null;
        // TODO 提取成util方法,定义成常量
        int random = new Random().nextInt(3);
        switch (random){
            case 0:
                // 0 是person 类型 ,构造出person的是对象发送到服务器
                message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersionTyp).
                        setPerson(MyDataInfo.Person.newBuilder().
                                setName("Person").setAge(19).setAddress("nanchang")).build();
                break;
            case 1:
                message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).
                        setDog(MyDataInfo.Dog.newBuilder().
                                setName("Dog").setAge(19)).build();
                break;
            case 2:
                message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).
                        setCat(MyDataInfo.Cat.newBuilder().
                                setName("Cat").setCity("nanchang")).build();
                break;
            default:
                // TODO 错误类型
                break;
        }


        ctx.channel().writeAndFlush(message);
        ctx.close();
    }
}

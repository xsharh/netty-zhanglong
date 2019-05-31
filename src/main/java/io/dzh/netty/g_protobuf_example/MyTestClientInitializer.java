package io.dzh.netty.g_protobuf_example;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;


/**
 * @author Do
 * @description 客户端initializer
 * 变更：MyDataInfo.Person 发送类型数据只有一种，必须多种消息，两种方法实现，
 * 1.自定义协议，自定义解码器目前物联网用的这种
 * 2.重新定义protobuf 消息，利用枚举 ，方便扩展性强
 * @date 2019-02-20 20:11
 */
public class MyTestClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 使用解码器
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        // 将protobuf 数组转化成对象,可以自己定义协议
        pipeline.addLast(new ProtobufDecoder(MyDataInfo.MyMessage.getDefaultInstance()));
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
        pipeline.addLast(new MyTestClientHandler());
    }
}

package io.dzh.netty.m_codec_handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

/**
 * @author Do
 * @description
 * @date 2019-02-19 23:08
 */
public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        // 服务器端地址
//        System.out.println("client: 收到消息");
        // 服务器向客户端发送的数据
        System.out.println("client: 收到消息--"+msg);
        // 向服务器发送一个标准utc时间
//        ctx.writeAndFlush("from client: "+LocalDateTime.now().toString());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.getStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("client:与服务器连接了");
        System.out.println("client:发送消息--123456");
        ctx.writeAndFlush(123456);
        System.out.println("client:发送消息--helloworld");
        ctx.writeAndFlush(Unpooled.copiedBuffer("helloworld", Charset.forName("utf-8")));


    }
}

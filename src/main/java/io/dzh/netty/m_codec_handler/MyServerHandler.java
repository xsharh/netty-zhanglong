package io.dzh.netty.m_codec_handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author Do
 * @description
 * @date 2019-02-19 22:27
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
//        System.out.println(ctx.channel().remoteAddress()+","+msg);
        System.out.println("server:收到消息--"+ msg);
        System.out.println("server:发送消息--654321L");
        ctx.writeAndFlush(654321L);
        // 写与刷出去, 可以分开
//        ctx.channel().writeAndFlush("from server: "+ UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

package io.dzh.netty.b_socketexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author Do
 * @description
 * @date 2019-02-19 22:27
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        // 写与刷出去, 可以分开
        ctx.channel().writeAndFlush("from server: "+ UUID.randomUUID());
    }
}

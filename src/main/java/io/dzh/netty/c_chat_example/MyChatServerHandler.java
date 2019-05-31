package io.dzh.netty.c_chat_example;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author Do
 * @description
 * @date 2019-02-20 11:37
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    // 保存channel,单线程,可扩展性不强
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        channelGroup.forEach(ch->{
            if (channel != ch){
                ch.writeAndFlush(channel.remoteAddress()+"发送的消息: "+msg+"\n");
            }else{
                ch.writeAndFlush("[自己]"+ msg +"\n");
            }
        });


    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器]-"+ channel.remoteAddress()+ "加入\n");
        channelGroup.add(channel);
        //System.out.println(channel.remoteAddress()+"加入\n");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器]-"+ channel.remoteAddress()+ "离开\n");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("服务器: "+channel.remoteAddress()+"上线\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("服务器: "+channel.remoteAddress()+"下线\n");
    }
}

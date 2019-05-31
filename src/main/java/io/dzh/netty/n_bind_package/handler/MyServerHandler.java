package io.dzh.netty.n_bind_package.handler;

import io.dzh.netty.n_bind_package.protocol.PersonProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author Do
 * @description
 * @date 2019-02-19 22:27
 */
public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private  int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        //读取
        int length = msg.getLength();
        byte[] bytes =msg.getContent();

        String message = new String(bytes, Charset.forName("utf-8"));
        System.out.println("服务器收到的消息长度: " + length);
        System.out.println("服务器收到的消息内容: " + message);
        System.out.println("服务器接收到的消息数量: " + (++this.count));

        // 构造数据返回
        String content = UUID.randomUUID().toString();
        int responseLength = content.getBytes("utf-8").length;
        byte[] responseContent = content.getBytes("utf-8");

        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(responseLength);
        personProtocol.setContent(responseContent);
        ctx.writeAndFlush(personProtocol);
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

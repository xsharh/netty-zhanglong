package io.dzh.netty.n_bind_package.handler;

import io.dzh.netty.n_bind_package.protocol.PersonProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.nio.charset.Charset;


/**
 * @author Do
 * @description
 * @date 2019-02-19 23:08
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {

        int length = msg.getLength();
        byte[] content = msg.getContent();
        System.out.println("客户端接收到的消息: ");
        System.out.println("长度: " + length);
        System.out.println("内容: " + new String(content, Charset.forName("utf-8")));
        System.out.println("客户端接受到的消息数量: " + ++count);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client active....");
        for (int i = 0; i < 10; i++) {
            String message = "send from client: "+i+"\n";
            int length = message.getBytes("utf-8").length;
            byte[] bytes = message.getBytes("utf-8");
            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setContent(bytes);
            personProtocol.setLength(length);
            ctx.writeAndFlush(personProtocol);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.getStackTrace();
        ctx.close();
    }
}

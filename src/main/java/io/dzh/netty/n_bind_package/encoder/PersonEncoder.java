package io.dzh.netty.n_bind_package.encoder;

import io.dzh.netty.n_bind_package.protocol.PersonProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Do
 * @description 协议解码器,将对象转换成字节
 * @date 2019-05-30 18:00
 */
public class PersonEncoder extends MessageToByteEncoder<PersonProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("PersonEncoder invoked...");
         out.writeInt(msg.getLength());
         out.writeBytes(msg.getContent());
    }
}

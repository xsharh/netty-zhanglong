package io.dzh.netty.n_bind_package.decoder;

import io.dzh.netty.n_bind_package.protocol.PersonProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Do
 * @description Person 解码器
 * @date 2019-05-30 17:45
 */
public class PersonDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("PersonDecoder invoked....");
        // 判断长度是否大于等于一个整形(这步可以省略,ReplayingDecoder已经实现了)
        if (in.readableBytes()>=Integer.BYTES){
            // 读取一个整形
            int length = in.readInt();
            // 设置内容的字节长度
            byte[] content = new byte[length];
            // 填充内容
            in.readBytes(content);
            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setLength(length);
            personProtocol.setContent(content);
            out.add(personProtocol);
        }
    }
}

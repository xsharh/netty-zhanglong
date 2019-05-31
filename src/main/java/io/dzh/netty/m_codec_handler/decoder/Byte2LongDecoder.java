package io.dzh.netty.m_codec_handler.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Do
 * @description 自定义解码器 Long 类型的解码器,将字节转为Long类型的入栈处理器
 * @date 2019-05-29 16:40
 */
public class Byte2LongDecoder extends ByteToMessageDecoder   {
    @Override

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("decode() invoked....");
        System.out.println(in.readableBytes()
        );

        if (in.readableBytes() >= 8){
            out.add(in.readLong());
        }
     }

}

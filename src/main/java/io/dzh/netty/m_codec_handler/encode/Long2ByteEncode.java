package io.dzh.netty.m_codec_handler.encode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @author Do
 * @description 自定义编码器,将long 类型编码成字节,出栈处理器
 * @date 2019-05-29 16:40
 */
public class Long2ByteEncode extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoke... ");
        System.out.println("encode: " + msg);
        out.writeLong(msg);
    }
}

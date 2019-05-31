package io.dzh.netty.m_codec_handler.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Do
 * @description 自定义解码器 Long 类型的解码器,将字节转为Long类型的入栈处理器
 *              泛型是状态管理,这里不需要,void
 * @date 2019-05-29 16:40
 */
public class Replaying_Byte2LongDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("ReplayingDecoder_decode() invoked....");
        System.out.println("readableBytes: " + in.readableBytes());
        // 继承 ReplayingDecoder 不需要检查输入的byteBuf 的字节数够不够读取
            out.add(in.readLong());
     }


}

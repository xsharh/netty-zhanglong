package io.dzh.netty.m_codec_handler;

import io.dzh.netty.m_codec_handler.decoder.Byte2LongDecoder;
import io.dzh.netty.m_codec_handler.decoder.Replaying_Byte2LongDecoder;
import io.dzh.netty.m_codec_handler.encode.Long2ByteEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Do
 * @description 自定义编解码器
 * @date 2019-02-19 22:26
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 添加一个入栈处理器,  解码器
//        pipeline.addLast(new Byte2LongDecoder());
        pipeline.addLast(new Replaying_Byte2LongDecoder());
        pipeline.addLast(new Long2ByteEncode());
        pipeline.addLast(new MyServerHandler());
    }
}

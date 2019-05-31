package io.dzh.netty.n_bind_package;

import io.dzh.netty.n_bind_package.decoder.PersonDecoder;
import io.dzh.netty.n_bind_package.encoder.PersonEncoder;
import io.dzh.netty.n_bind_package.handler.MyClientHandler;
import io.dzh.netty.n_bind_package.handler.MyServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @author Do
 * @description
 * @date 2019-02-19 22:46
 */
public class MyClient {
    public static void main(String[] args)throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            // handler 针对boss, childHandler针对worker
            bootstrap.group(workerGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new PersonDecoder());
                    pipeline.addLast(new PersonEncoder());
                    pipeline.addLast(new MyClientHandler());
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
        }

    }

}

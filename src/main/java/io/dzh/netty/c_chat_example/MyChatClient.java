package io.dzh.netty.c_chat_example;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Do
 * @description
 * @date 2019-02-20 20:06
 */
public class MyChatClient{
        public static void main(String[] args)throws Exception {
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                // handler 针对boss, childHandler针对worker
                bootstrap.group(workerGroup).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());
                Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                for(; ;){
                    channel.writeAndFlush(br.readLine()+"\r\n");
                }
            }finally {
                workerGroup.shutdownGracefully();
            }

        }

}

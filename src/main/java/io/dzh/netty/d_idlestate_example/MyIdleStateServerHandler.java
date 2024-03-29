package io.dzh.netty.d_idlestate_example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author Do
 * @description 继承适配器, 重写用户事件触发
 * @date 2019-02-20 22:08
 */
public class MyIdleStateServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 空闲状态事件
        if(evt instanceof IdleStateEvent){
            IdleStateEvent stateEvent = (IdleStateEvent)evt;
            String eventType = null;

            switch (stateEvent.state()){
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"超时事件: "+ eventType);
            ctx.channel().close();
        }
    }

}

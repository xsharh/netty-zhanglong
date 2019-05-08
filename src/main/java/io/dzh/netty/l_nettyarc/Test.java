package io.dzh.netty.l_nettyarc;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * @author Do
 * @description
 * @date 2019-04-11 00:46
 */
public class Test {
    public  static int DEFAULT_EVENT_LOOP_THREADS = 0;
    public static void main(String[] args) {
        DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        System.out.println(DEFAULT_EVENT_LOOP_THREADS);
    }

}

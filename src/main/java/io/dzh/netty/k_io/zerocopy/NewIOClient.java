package io.dzh.netty.k_io.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Do
 * @description
 * @date 2019-04-10 18:47
 */
public class NewIOClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8899));
        socketChannel.configureBlocking(true);
        //文件
//        String fileName = "E:\\contos7\\contos7.3+dockerf.ova";
        String fileName = "G:\\2018\\netty高并发-张龙\\47_Netty服务器与客户端编码 模式回顾及源码分析准备.mp4";
        // 获取输入流输出流

        // 获取文件通道
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long startTime = System.currentTimeMillis();
        // 传输到 开始位置, 多少, 目标channel
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总字节: "+ transferCount + ", 耗时: " + (System.currentTimeMillis() - startTime));

        socketChannel.close();
    }
}

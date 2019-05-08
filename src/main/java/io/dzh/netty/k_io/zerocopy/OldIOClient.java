package io.dzh.netty.k_io.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @author Do
 * @description 使用传统io 向网络另一端发送数据
 * @date 2019-04-10 17:27
 */
public class OldIOClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);
        //文件
//        String fileName = "E:\\contos7\\contos7.3+dockerf.ova";
        String fileName = "G:\\2018\\netty高并发-张龙\\47_Netty服务器与客户端编码模式回顾及源码分析准备.mp4";
        // 获取输入流输出流
        FileInputStream fileInputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        // 准备缓冲区
        byte[] buffer = new byte[40960];
        long readCount;
        long total = 0;

        long start = System.currentTimeMillis();
        while ((readCount = fileInputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
            System.out.println(System.currentTimeMillis());
        }
        System.out.println("发送总字节: "+ total + ", 耗时: " + (System.currentTimeMillis() - start));

        fileInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}

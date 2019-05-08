package io.dzh.netty.k_io.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Do
 * @description
 * @date 2019-04-10 17:03
 */
public class OldIOServer{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true) {
            // 阻塞 等待客户端连接,返回一个socket
            Socket socket = serverSocket.accept();

            //使用 包装流 包装二进制流对象, 可以从中读取java基本类型或
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                // 定义缓冲区
                byte[] byteArray = new byte[4096];
                while (true) {
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);

                    if (-1 == readCount) {
                        break;
                    }
                }

            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

}

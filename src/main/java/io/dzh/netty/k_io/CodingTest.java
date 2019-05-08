package io.dzh.netty.k_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author Do
 * @description 探究编解码问题
 * @date 2019-04-09 23:02
 */
public class CodingTest {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        // 以只读的方式, 创建一个带操作指针的文件操作对象
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        // 以可读/可写的方式, 创建一个带操作指针的文件操作对象
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");
        
        // 分别获取通道
        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

        // 获取文件字节
        long inputFileLength = new File(inputFile).length();
        // 获取内存文件映射buffer
        MappedByteBuffer inputData = inputFileChannel.
                map(FileChannel.MapMode.READ_ONLY,0, inputFileLength);

        // 设置字符对象,编解码对象
        Charset charset = Charset.forName("iso8859-1");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        // 解码,编码
        CharBuffer charBuffer = decoder.decode(inputData);
        ByteBuffer byteBuffer = encoder.encode(charBuffer);

        // 写入
        outputFileChannel.write(byteBuffer);

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();


        System.out.println("==========打印编码=============");
        Charset.availableCharsets().forEach((k,v)-> {
            System.out.println(k + "," + v);
        });
        System.out.println("==========打印编码=============");
    }
}

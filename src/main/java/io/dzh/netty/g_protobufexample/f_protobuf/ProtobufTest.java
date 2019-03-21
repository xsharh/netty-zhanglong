package io.dzh.netty.g_protobufexample.f_protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author Do
 * @description
 * @date 2019-03-07 23:09
 */
public class ProtobufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().
                setName("zhangsan").setAge(18).setAddress("jiangxi").build();

        // 序列化 反序列
         byte [] student2ByteArray = student.toByteArray();

         DataInfo.Student student1 = DataInfo.Student.parseFrom(student2ByteArray);
        System.out.println(student1);
    }
}

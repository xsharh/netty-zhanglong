package io.dzh.netty.h_thrift_example.service;

import io.dzh.netty.h_thrift_example.service.generated.Person;
import io.dzh.netty.h_thrift_example.service.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author Do
 * @description
 * @date 2019-03-10 00:04
 */
public class ThriftClient {
    public static void main(String[] args) {
        // 传输层,客户端 班定主机,超时时间
        TTransport tTransport = new TFastFramedTransport(new TSocket("localhost",8899),600);
        // 协议和传输必须以服务端对应
        TProtocol tProtocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(tProtocol);
        try {
            // 打开socket
            tTransport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println( person);
            System.out.println("==============");

        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage(),ex);

        }finally{
            tTransport.close();
        }
    }

}

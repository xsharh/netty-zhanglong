package io.dzh.netty.h_thrift_example.service;

import io.dzh.netty.h_thrift_example.service.generated.PersonService;
import io.dzh.netty.h_thrift_example.service.impl.PersonServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * @author Do
 * @description thrift 非阻塞的服务器
 * @date 2019-03-09 15:36
 */
public class ThriftServer {
    public static void main(String[] args) throws Exception{
        // 高可用非阻塞套接字
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor =
                new PersonService.Processor<>(new PersonServiceImpl());
        // 压缩协议层
        arg.protocolFactory(new TCompactProtocol.Factory());
        // 传输层
        arg.transportFactory(new TFastFramedTransport.Factory());
        // 处理
        arg.processorFactory(new TProcessorFactory(processor));
        // 半同步半异步服务
        TServer tServer = new THsHaServer(arg);

        System.out.println("Thrift Server Start!");
        // 阻塞启动
        tServer.serve();

    }
}

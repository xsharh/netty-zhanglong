package io.dzh.netty.i_grpc_example;

import io.dzh.netty.z_proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * @author Do
 * @description grpc客户端
 * @date 2019-03-18 21:31
 */
public class GrpcClient {
    public static void main(String[] args) {
        // 一个使用明文的传输层
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext().build();
        //同步的发送桩
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        //异步的发送桩
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);

        // req:resp
        MyResponse myResponse = blockingStub.getRealnameByRealname(MyRequest.newBuilder().setRealname("zhangsan").build());
        System.out.println(myResponse.getRealname() );
        System.out.println("=======================next=================");

        // req:stream
        Iterator<StudentResponse> students = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(18).build());
        while (students.hasNext()) {
            StudentResponse next =  students.next();
            System.out.println(next.getName()+","+next.getAge()+","+next.getCity());
        }
        System.out.println("=======================next===========================");

        // stream:resp 第一部分
        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
            // 接收到服务端最终返回的数据
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().stream().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("*********************");
                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("server completed!");
            }
        };
        // stream:resp 第二部分
        // 客户端以流的形式发送请求, 都是异步发送
        StreamObserver<StudentRequest> studentRequestListStreamObserver1 = stub.getStudentsWrapperByAges(studentResponseListStreamObserver);
        // 客户端发送多个请求
        studentRequestListStreamObserver1.onNext(StudentRequest.newBuilder().setAge(10).build());
        studentRequestListStreamObserver1.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentRequestListStreamObserver1.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestListStreamObserver1.onNext(StudentRequest.newBuilder().setAge(40).build());

        // 客户端发送结束
        studentRequestListStreamObserver1.onCompleted();

        System.out.println("=======================next===========================");
        // stream:stream  第一部分
        StreamObserver<StreamRequest> requestStreamObserver  = stub.biTalk(new StreamObserver<StreamResponse>() {
            // 收到服务器返回的结果
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getStackTrace());
            }
            // 服务器关闭
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
        // stream:stream  第二部分
        for (int i = 0; i < 10; i++) {
           requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        // 如果不休眠,异步的桩(stub)直接结束程序,还没来的等服务器返回程序就结束
        try {
            Thread.sleep(520000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

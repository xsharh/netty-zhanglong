package io.dzh.netty.i_grpc_example;

import io.dzh.netty.z_proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * @author Do
 * @description 服务端实现,4种传输模型
 * @date 2019-03-18 20:48
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    // 1 <--> 1
    @Override
    public void getRealnameByRealname(MyRequest request, StreamObserver<MyResponse> responseObserver) {
//        super.getRealnameByRealname(request, responseObserver);
        System.out.println("接收到客户端的信息:" + request.getRealname());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        // 方法调用结束
        responseObserver.onCompleted();
    }
    // 1 <--> n
    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端的信息:" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("lisi").setAge(18).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(18).setCity("上海").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(18).setCity("广州").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("为其").setAge(18).setCity("天津").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("找吧").setAge(18).setCity("南昌").build());

        responseObserver.onCompleted();

    }

    // n <--> 1
    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {


        // 返回一个接口的实现的回调, 客户端发出流式的请求
        return new StreamObserver<StudentRequest>() {
            // 请求一次调一次
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("客户端发了一次请求!");
                System.out.println(value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("异常!!");
            }
            // 客户端请求完调用
            @Override
            public void onCompleted() {
                responseObserver.onNext(StudentResponseList.newBuilder().
                        addStudentResponse(StudentResponse.newBuilder().setName("人1").setAge(18).setCity("bj")).
                        addStudentResponse(StudentResponse.newBuilder().setName("人1").setAge(18).setCity("bj")).build());

                responseObserver.onCompleted();

            }
        };
    }

    // n <--> n
    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getStackTrace());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}

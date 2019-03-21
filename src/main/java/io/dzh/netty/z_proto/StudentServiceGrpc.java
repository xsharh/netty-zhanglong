package io.dzh.netty.z_proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "io.do.proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.dzh.netty.z_proto.MyRequest,
      io.dzh.netty.z_proto.MyResponse> getGetRealnameByRealnameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealnameByRealname",
      requestType = io.dzh.netty.z_proto.MyRequest.class,
      responseType = io.dzh.netty.z_proto.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.dzh.netty.z_proto.MyRequest,
      io.dzh.netty.z_proto.MyResponse> getGetRealnameByRealnameMethod() {
    io.grpc.MethodDescriptor<io.dzh.netty.z_proto.MyRequest, io.dzh.netty.z_proto.MyResponse> getGetRealnameByRealnameMethod;
    if ((getGetRealnameByRealnameMethod = StudentServiceGrpc.getGetRealnameByRealnameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealnameByRealnameMethod = StudentServiceGrpc.getGetRealnameByRealnameMethod) == null) {
          StudentServiceGrpc.getGetRealnameByRealnameMethod = getGetRealnameByRealnameMethod = 
              io.grpc.MethodDescriptor.<io.dzh.netty.z_proto.MyRequest, io.dzh.netty.z_proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "io.do.proto.StudentService", "getRealnameByRealname"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealnameByRealname"))
                  .build();
          }
        }
     }
     return getGetRealnameByRealnameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StudentRequest,
      io.dzh.netty.z_proto.StudentResponse> getGetStudentsByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudentsByAge",
      requestType = io.dzh.netty.z_proto.StudentRequest.class,
      responseType = io.dzh.netty.z_proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StudentRequest,
      io.dzh.netty.z_proto.StudentResponse> getGetStudentsByAgeMethod() {
    io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StudentRequest, io.dzh.netty.z_proto.StudentResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = StudentServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = StudentServiceGrpc.getGetStudentsByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod = 
              io.grpc.MethodDescriptor.<io.dzh.netty.z_proto.StudentRequest, io.dzh.netty.z_proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "io.do.proto.StudentService", "getStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getStudentsByAge"))
                  .build();
          }
        }
     }
     return getGetStudentsByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StudentRequest,
      io.dzh.netty.z_proto.StudentResponseList> getGetStudentsWrapperByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudentsWrapperByAges",
      requestType = io.dzh.netty.z_proto.StudentRequest.class,
      responseType = io.dzh.netty.z_proto.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StudentRequest,
      io.dzh.netty.z_proto.StudentResponseList> getGetStudentsWrapperByAgesMethod() {
    io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StudentRequest, io.dzh.netty.z_proto.StudentResponseList> getGetStudentsWrapperByAgesMethod;
    if ((getGetStudentsWrapperByAgesMethod = StudentServiceGrpc.getGetStudentsWrapperByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsWrapperByAgesMethod = StudentServiceGrpc.getGetStudentsWrapperByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentsWrapperByAgesMethod = getGetStudentsWrapperByAgesMethod = 
              io.grpc.MethodDescriptor.<io.dzh.netty.z_proto.StudentRequest, io.dzh.netty.z_proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "io.do.proto.StudentService", "getStudentsWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getStudentsWrapperByAges"))
                  .build();
          }
        }
     }
     return getGetStudentsWrapperByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StreamRequest,
      io.dzh.netty.z_proto.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "biTalk",
      requestType = io.dzh.netty.z_proto.StreamRequest.class,
      responseType = io.dzh.netty.z_proto.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StreamRequest,
      io.dzh.netty.z_proto.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<io.dzh.netty.z_proto.StreamRequest, io.dzh.netty.z_proto.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = StudentServiceGrpc.getBiTalkMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBiTalkMethod = StudentServiceGrpc.getBiTalkMethod) == null) {
          StudentServiceGrpc.getBiTalkMethod = getBiTalkMethod = 
              io.grpc.MethodDescriptor.<io.dzh.netty.z_proto.StreamRequest, io.dzh.netty.z_proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "io.do.proto.StudentService", "biTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.dzh.netty.z_proto.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("biTalk"))
                  .build();
          }
        }
     }
     return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * req,resp;
     * </pre>
     */
    public void getRealnameByRealname(io.dzh.netty.z_proto.MyRequest request,
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealnameByRealnameMethod(), responseObserver);
    }

    /**
     * <pre>
     * req,stream; 与thrift不同, grpc 必须使用message 传输
     * </pre>
     */
    public void getStudentsByAge(io.dzh.netty.z_proto.StudentRequest request,
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByAgeMethod(), responseObserver);
    }

    /**
     * <pre>
     * stream,resp;
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentRequest> getStudentsWrapperByAges(
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsWrapperByAgesMethod(), responseObserver);
    }

    /**
     * <pre>
     * stream,stream;
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealnameByRealnameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.dzh.netty.z_proto.MyRequest,
                io.dzh.netty.z_proto.MyResponse>(
                  this, METHODID_GET_REALNAME_BY_REALNAME)))
          .addMethod(
            getGetStudentsByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.dzh.netty.z_proto.StudentRequest,
                io.dzh.netty.z_proto.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentsWrapperByAgesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.dzh.netty.z_proto.StudentRequest,
                io.dzh.netty.z_proto.StudentResponseList>(
                  this, METHODID_GET_STUDENTS_WRAPPER_BY_AGES)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.dzh.netty.z_proto.StreamRequest,
                io.dzh.netty.z_proto.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * req,resp;
     * </pre>
     */
    public void getRealnameByRealname(io.dzh.netty.z_proto.MyRequest request,
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealnameByRealnameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * req,stream; 与thrift不同, grpc 必须使用message 传输
     * </pre>
     */
    public void getStudentsByAge(io.dzh.netty.z_proto.StudentRequest request,
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * stream,resp;
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentRequest> getStudentsWrapperByAges(
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentsWrapperByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * stream,stream;
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * req,resp;
     * </pre>
     */
    public io.dzh.netty.z_proto.MyResponse getRealnameByRealname(io.dzh.netty.z_proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealnameByRealnameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * req,stream; 与thrift不同, grpc 必须使用message 传输
     * </pre>
     */
    public java.util.Iterator<io.dzh.netty.z_proto.StudentResponse> getStudentsByAge(
        io.dzh.netty.z_proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * req,resp;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.dzh.netty.z_proto.MyResponse> getRealnameByRealname(
        io.dzh.netty.z_proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealnameByRealnameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REALNAME_BY_REALNAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENTS_WRAPPER_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REALNAME_BY_REALNAME:
          serviceImpl.getRealnameByRealname((io.dzh.netty.z_proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((io.dzh.netty.z_proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENTS_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsWrapperByAges(
              (io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<io.dzh.netty.z_proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.dzh.netty.z_proto.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealnameByRealnameMethod())
              .addMethod(getGetStudentsByAgeMethod())
              .addMethod(getGetStudentsWrapperByAgesMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}

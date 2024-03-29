// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package io.dzh.netty.z_proto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_StudentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_StudentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_StudentResponseList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_StreamRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_StreamRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_do_proto_StreamResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_do_proto_StreamResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rStudent.proto\022\013io.do.proto\"\035\n\tMyReques" +
      "t\022\020\n\010realname\030\001 \001(\t\"\036\n\nMyResponse\022\020\n\010rea" +
      "lname\030\002 \001(\t\"\035\n\016StudentRequest\022\013\n\003age\030\001 \001" +
      "(\005\":\n\017StudentResponse\022\014\n\004name\030\001 \001(\t\022\013\n\003a" +
      "ge\030\002 \001(\005\022\014\n\004city\030\003 \001(\t\"L\n\023StudentRespons" +
      "eList\0225\n\017studentResponse\030\001 \003(\0132\034.io.do.p" +
      "roto.StudentResponse\"%\n\rStreamRequest\022\024\n" +
      "\014request_info\030\001 \001(\t\"\'\n\016StreamResponse\022\025\n" +
      "\rresponse_info\030\001 \001(\t2\327\002\n\016StudentService\022" +
      "J\n\025getRealnameByRealname\022\026.io.do.proto.M" +
      "yRequest\032\027.io.do.proto.MyResponse\"\000\022Q\n\020g" +
      "etStudentsByAge\022\033.io.do.proto.StudentReq" +
      "uest\032\034.io.do.proto.StudentResponse\"\0000\001\022]" +
      "\n\030getStudentsWrapperByAges\022\033.io.do.proto" +
      ".StudentRequest\032 .io.do.proto.StudentRes" +
      "ponseList\"\000(\001\022G\n\006biTalk\022\032.io.do.proto.St" +
      "reamRequest\032\033.io.do.proto.StreamResponse" +
      "\"\000(\0010\001B&\n\024io.dzh.netty.z_protoB\014StudentP" +
      "rotoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_io_do_proto_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_do_proto_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_MyRequest_descriptor,
        new java.lang.String[] { "Realname", });
    internal_static_io_do_proto_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_io_do_proto_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_MyResponse_descriptor,
        new java.lang.String[] { "Realname", });
    internal_static_io_do_proto_StudentRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_io_do_proto_StudentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_StudentRequest_descriptor,
        new java.lang.String[] { "Age", });
    internal_static_io_do_proto_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_io_do_proto_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_StudentResponse_descriptor,
        new java.lang.String[] { "Name", "Age", "City", });
    internal_static_io_do_proto_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_io_do_proto_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_StudentResponseList_descriptor,
        new java.lang.String[] { "StudentResponse", });
    internal_static_io_do_proto_StreamRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_io_do_proto_StreamRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_StreamRequest_descriptor,
        new java.lang.String[] { "RequestInfo", });
    internal_static_io_do_proto_StreamResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_io_do_proto_StreamResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_do_proto_StreamResponse_descriptor,
        new java.lang.String[] { "ResponseInfo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

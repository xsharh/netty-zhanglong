// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var proto_Student_pb = require('./Student_pb.js');

function serialize_io_do_proto_MyRequest(arg) {
  if (!(arg instanceof proto_Student_pb.MyRequest)) {
    throw new Error('Expected argument of type io.do.proto.MyRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_MyRequest(buffer_arg) {
  return proto_Student_pb.MyRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_io_do_proto_MyResponse(arg) {
  if (!(arg instanceof proto_Student_pb.MyResponse)) {
    throw new Error('Expected argument of type io.do.proto.MyResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_MyResponse(buffer_arg) {
  return proto_Student_pb.MyResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_io_do_proto_StreamRequest(arg) {
  if (!(arg instanceof proto_Student_pb.StreamRequest)) {
    throw new Error('Expected argument of type io.do.proto.StreamRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_StreamRequest(buffer_arg) {
  return proto_Student_pb.StreamRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_io_do_proto_StreamResponse(arg) {
  if (!(arg instanceof proto_Student_pb.StreamResponse)) {
    throw new Error('Expected argument of type io.do.proto.StreamResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_StreamResponse(buffer_arg) {
  return proto_Student_pb.StreamResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_io_do_proto_StudentRequest(arg) {
  if (!(arg instanceof proto_Student_pb.StudentRequest)) {
    throw new Error('Expected argument of type io.do.proto.StudentRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_StudentRequest(buffer_arg) {
  return proto_Student_pb.StudentRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_io_do_proto_StudentResponse(arg) {
  if (!(arg instanceof proto_Student_pb.StudentResponse)) {
    throw new Error('Expected argument of type io.do.proto.StudentResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_StudentResponse(buffer_arg) {
  return proto_Student_pb.StudentResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_io_do_proto_StudentResponseList(arg) {
  if (!(arg instanceof proto_Student_pb.StudentResponseList)) {
    throw new Error('Expected argument of type io.do.proto.StudentResponseList');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_io_do_proto_StudentResponseList(buffer_arg) {
  return proto_Student_pb.StudentResponseList.deserializeBinary(new Uint8Array(buffer_arg));
}


// 四种通讯模式 req,resp; req,stream; stream,resp; stream,stream;
// gradlew generateProto 代码生成
//
var StudentServiceService = exports.StudentServiceService = {
  // req,resp;
  getRealnameByRealname: {
    path: '/io.do.proto.StudentService/getRealnameByRealname',
    requestStream: false,
    responseStream: false,
    requestType: proto_Student_pb.MyRequest,
    responseType: proto_Student_pb.MyResponse,
    requestSerialize: serialize_io_do_proto_MyRequest,
    requestDeserialize: deserialize_io_do_proto_MyRequest,
    responseSerialize: serialize_io_do_proto_MyResponse,
    responseDeserialize: deserialize_io_do_proto_MyResponse,
  },
  // req,stream; 与thrift不同, grpc 必须使用message 传输
  getStudentsByAge: {
    path: '/io.do.proto.StudentService/getStudentsByAge',
    requestStream: false,
    responseStream: true,
    requestType: proto_Student_pb.StudentRequest,
    responseType: proto_Student_pb.StudentResponse,
    requestSerialize: serialize_io_do_proto_StudentRequest,
    requestDeserialize: deserialize_io_do_proto_StudentRequest,
    responseSerialize: serialize_io_do_proto_StudentResponse,
    responseDeserialize: deserialize_io_do_proto_StudentResponse,
  },
  // stream,resp;
  getStudentsWrapperByAges: {
    path: '/io.do.proto.StudentService/getStudentsWrapperByAges',
    requestStream: true,
    responseStream: false,
    requestType: proto_Student_pb.StudentRequest,
    responseType: proto_Student_pb.StudentResponseList,
    requestSerialize: serialize_io_do_proto_StudentRequest,
    requestDeserialize: deserialize_io_do_proto_StudentRequest,
    responseSerialize: serialize_io_do_proto_StudentResponseList,
    responseDeserialize: deserialize_io_do_proto_StudentResponseList,
  },
  // stream,stream;
  biTalk: {
    path: '/io.do.proto.StudentService/biTalk',
    requestStream: true,
    responseStream: true,
    requestType: proto_Student_pb.StreamRequest,
    responseType: proto_Student_pb.StreamResponse,
    requestSerialize: serialize_io_do_proto_StreamRequest,
    requestDeserialize: deserialize_io_do_proto_StreamRequest,
    responseSerialize: serialize_io_do_proto_StreamResponse,
    responseDeserialize: deserialize_io_do_proto_StreamResponse,
  },
};

exports.StudentServiceClient = grpc.makeGenericClientConstructor(StudentServiceService);

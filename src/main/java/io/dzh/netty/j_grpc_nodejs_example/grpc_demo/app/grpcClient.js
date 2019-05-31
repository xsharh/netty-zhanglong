// 项目中运行 node app\grpcClient.js

//　动态生成服务端，客户端
var PROTO_FILE_PATH =  '.\\proto\\'+'Student.proto'
console.log(PROTO_FILE_PATH)
// 引入grpc
var grpc = require('grpc')
// 加载proto
var grpcService = grpc.load(PROTO_FILE_PATH).io.do.proto;
// 创建一个不安全的客户端
var client = new grpcService.StudentService("localhost:8899", grpc.credentials.createInsecure());
// 调用java方法
client.getRealnameByRealname({realname:'lisi'}, function(error, res){
    console.log(res)
})
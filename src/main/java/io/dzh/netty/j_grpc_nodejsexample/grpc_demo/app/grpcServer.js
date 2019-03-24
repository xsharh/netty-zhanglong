// 项目中运行 node app\grpcClient.js

//　动态生成服务端，客户端
var PROTO_FILE_PATH =  '.\\proto\\'+'Student.proto'
console.log(PROTO_FILE_PATH)
// 引入grpc
var grpc = require('grpc')
// 加载proto
var grpcService = grpc.load(PROTO_FILE_PATH).io.do.proto;

// 定义server
var server = new grpc.Server();
// 写对应关系
server.addService(grpcService.StudentService.service, { 
    getRealnameByRealname: getRealnameByRealname,
    getStudentsByAge: getStudentsByAge,
    getStudentsWrapperByAges: getStudentsWrapperByAges,
    biTalk: biTalk
})
// 绑定服务端
server.bind('localhost:8899', grpc.ServerCredentials.createInsecure())
server.start()

// 定义返回方法  (请求,回调)
function getRealnameByRealname(call, callback){
    console.log("call",call)
    // 错误,数据
    callback(null, {realname: 'zhangsan'})
}

function getStudentsByAge(){

}
function getStudentsWrapperByAges(){

}
function biTalk(){

}
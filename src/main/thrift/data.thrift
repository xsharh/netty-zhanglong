namespace java thrift.generated //java package 路径
namespace py py.thrift.generated
// 取别名
typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

// 定义数据结构
struct Person {
    1:optional String username,
    2:optional int age,
    3:optional boolean married
}

// 定义异常
exception DataException {
    1:optional String message,
    2:optional String callStack,
    3:optional String date
}

// 定义接口
service PersonService {
    Person getPersonByUsername (1:required String username) throws(1:DataException dataException),
    void savePerson (1:required Person person) throws(1:DataException dataException)
}
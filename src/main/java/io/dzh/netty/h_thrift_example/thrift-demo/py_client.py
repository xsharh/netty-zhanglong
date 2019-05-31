# _*_ coding: utf-8 _*_

from py.thrift.generated import PersonService,ttypes

from thrift import Thrift
from thrift.transport import TTransport
from thrift.transport import TSocket
from thrift.protocol import TCompactProtocol
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

'''' java 作为服务端，python作为客户端thrift进行n远程调用'''
try:
    # 绑定socket
    tSocket = TSocket.TSocket('192.168.238.1', 8899)
    # 超时
    tSocket.setTimeout(600)
    # 传输格式
    transport = TTransport.TFramedTransport(tSocket)
    # 协议
    protocol = TCompactProtocol.TCompactProtocol(transport)

    client = PersonService.Client(protocol)
    # 打开通道
    transport.open()

    person = client.getPersonByUsername("张三")
    print person.username
    print person.age
    print person.married

    newPerson = ttypes.Person()
    newPerson.username = "lisi"
    newPerson.age = 18
    newPerson.married = False

    client.savePerson(newPerson)


except Thrift.TException, ex:
    print "%s"%ex.message

















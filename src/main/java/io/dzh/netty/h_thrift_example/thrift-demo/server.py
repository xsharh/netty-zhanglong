# _*_ coding: utf-8 _*_

from py.thrift.generated import PersonService,ttypes

from thrift import Thrift
from PersonServerImpl import PersonServerImpl
from thrift.transport import TTransport
from thrift.transport import TSocket
from thrift.protocol import TCompactProtocol
from thrift.server import TServer
import sys


reload(sys)
sys.setdefaultencoding('utf-8')

try:
    PersonServerHandler = PersonServerImpl()
    # 处理器
    processor = PersonService.Processor()
    # 传输通道
    serverSocket = TSocket.TServerSocket(port=8899)
    # 传输格式
    transportFactory = TTransport.TFramedTransportFactory()
    # 传输协议
    protocolFactory = TCompactProtocol.TCompactProtocolFactory()
    # 传输模型
    server = TServer.TSimpleServer(processor, serverSocket, transportFactory, protocolFactory)
    server.serve()
except Thrift.TException, ex:
    print "%s"%ex.message

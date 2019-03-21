# _*_ coding: utf-8 _*_

from py.thrift.generated import PersonService,ttypes
import sys


class PersonServerImpl:

    ''''python 作为服务端，java 作为客户端thrift进行远程调用'''

    reload(sys)
    sys.setdefaultencoding('utf-8')

    def getPersonByUsername(self, username):
        person = ttypes.Person()
        person.username = username
        person.age = 20
        person.married = True
        return person

    def savePerson(self, person):
        print person.username
        print person.age
        print person.married




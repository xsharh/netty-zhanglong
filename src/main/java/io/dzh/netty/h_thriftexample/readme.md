####　`` 基于thrift生成:java python 的服务端与客户端实现``
> 实体类 与 api 在protobuf包中定义

> python 下载安装thrift的python依赖,
>> 进入thrift/lib/py执行 sudo python setup.py install
添加到虚拟环境中

> java 加上maven 配置, 或者gradle 配置

> 使用命令生成相应的代码 ``thrift-0.12.0.exe`` 官网下载
- thrift-0.12.0.exe --gen java data.thrift
- thrift-0.12.0.exe --gen py data.thrift
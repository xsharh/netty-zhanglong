####　`` 基于thrift生成:java python 的服务端与客户端实现``
> 服务定义在`io.dzh.netty.h_thrift_example`

> python 下载安装thrift的python依赖,
>> 进入thrift/lib/py执行 sudo python setup.py install
添加到虚拟环境中

> java 加上maven 配置, 或者gradle 配置

> 使用命令生成相应的代码 ``thrift-0.12.0.exe`` 官网下载
- thrift-0.12.0.exe --gen java data.thrift
- thrift-0.12.0.exe --gen py data.thrift




下载thrift win 或 linux:
        http://thrift.apache.org/download

加入依赖:

        <dependency>
          <groupId>org.apache.thrift</groupId>
          <artifactId>libthrift</artifactId>
          <version>0.12.0</version>
        </dependency>
        
安装编译器:
        http://thrift.apache.org/docs/install/
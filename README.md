# spring-cloud-alibaba
## 1.简介
>阿里巴巴结合自身微服务实践,开源的微服务全家桶  
在Spring Cloud项目中孵化,很可能成为Spring Cloud第二代的标准实现  
在业界广泛使用，已有很多成功案例

## 2.环境准备
* 安装nacos,配置数据持久化至mysql数据库  
>单节点启动指令  
进入到bin目录后，执行 startup.cmd -m standalone  
访问地址：  
http://localhost:8848/nacos/#/login
默认账号密码：  
nacos/nacos

## 3.模块介绍
### 3.1nacos-config-client
将nacos作为配置中心，读取nacos中的默认命名空间、默认分组中的nacos-config-client.yml配置文件
内容。配合@RefreshScope，实现配置动态更新。   
访问http://localhost:8085/testConfig，测试配置动态更新。

### 3.2nacos-config-client-load
将nacos作为配置中心，读取nacos中指定命名空间、指定分组的nacos-config-client.yml配置文件
内容。
* http://localhost:8086/testConfig，测试配置动态更新。
* http://localhost:8086/readCommon，测试共享配置读取。


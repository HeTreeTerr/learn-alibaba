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

* 安装sentinel
>下载jar包后，执行
java -jar sentinel-dashboard-1.7.0.jar --server.port=8090
启动服务  
访问地址：
http://localhost:8090/  
默认账号密码：
sentinel/sentinel

* 安装seate

## 3.模块介绍
### 3.1nacos-config-client
将nacos作为配置中心，读取nacos中的默认命名空间、默认分组中的nacos-config-client.yml配置文件
内容。配合@RefreshScope，实现配置动态更新。   
* 测试配置动态更新，访问http://localhost:8085/testConfig

### 3.2nacos-config-client-load
将nacos作为配置中心，读取nacos中指定命名空间、指定分组的nacos-config-client.yml配置文件
内容。
* 测试配置动态更新，http://localhost:8086/testConfig
* 测试共享配置读取，http://localhost:8086/readCommon

### 3.3nacos-discovery-provider
将nacos作为服务注册中心，将自身注册至注册中心。  
http://localhost:8082/demo?name=hss

### 3.4nacos-discovery-consumer
将nacos作为服务注册中心，将自身注册至注册中心。

* 通过loadBalancerClient远程服务调用，http://localhost:8080/testBalancer?name=hss
* 通过ribbon策略远程服务调用，http://localhost:8080/testRibbon?name=hss

### 3.5nacos-discovery-consumer-feign
将nacos作为服务注册中心，将自身注册至注册中心。
* 通过feign调用远程服务，http://localhost:8080/test?name=hss

### 3.6nacos-discovery-gateway-server
将nacos作为服务注册中心，将自身注册至注册中心。  
作为网关，反向代理nacos-discovery-provider。  
代理后的访问地址 http://localhost:8054/provider/demo?name=hss

### 3.7nacos-discovery-consumer-webflux
将nacos作为服务注册中心，将自身注册至注册中心。
* 通过webflux直接远程调用提供者，http://localhost:8080/test?name=hss
* 通过webflux方式，调用网关实现提供者远程调用，
http://localhost:8080/testGateway?name=hss

### 3.8sentinel-core-example
Sentinel以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务  
* 限流测试:http://localhost:18090/demo
* 限流测试:http://localhost:18090/resource
* 限流测试，携带参数:http://localhost:18090/param?type=123
* 熔断测试:http://localhost:18090/fallback?param=111

### 3.9sentinel-feign-provider
sentinel模块的提供者。  
* http://localhost:18082/feign
* http://localhost:18082/test

### 3.10sentinei-feign-gateway
sentinel模块的网关，使用gateway网关代理sentinel-feign-provider
* http://localhost:18084/test

### 3.11sentinei-feign-consumer
sentinel模块的消费者，远程调用sentinel-feign-provider
* http://localhost:18083/hello

### 3.12seate-pay-service
seate分布式事务解决方案工具，基本使用
* file.conf文件中，配置seate运行中数据的持久化
* registry.conf，配置注册自身至注册中心的规则
* 对外暴露支付接口：http://localhost:8030/pay

### 3.13seate-order-service
seate分布式事务解决方案工具，基本使用
* file.conf文件中，配置seate运行中数据的持久化
* registry.conf，配置注册自身至注册中心的规则
* 对外暴露支付接口：http://localhost:8020/order

### 3.14seate-biz-service
seate分布式事务解决方案工具，基本使用
* file.conf文件中，配置seate运行中数据的持久化
* registry.conf，配置注册自身至注册中心的规则
* 对外暴露支付接口：http://localhost:8010/biz

依赖@GlobalTransactional，实现先下单后支付的业务逻辑，同时保证分布式数据库事务
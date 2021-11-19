#租房后台管理系统介绍
系统主要模块有房源管理，租房管理，用户管理，三大块。
架构：SpringBoot+Springmvc+Dubbo+Mybatis
中间件使用:
mysql,redis,mongodb,zookeeper,Elasticsearch,
rocketmq,nginx。

项目代码目录：

![image](https://github.com/forestsss/img-folder/blob/765e0538c4e0ac624d260ede6956cbc2c556b131/zu1.png)

使用zookeeper作为注册中心：



使用mongoDB作为在线聊天的数据库。
导入依赖以及进行配置：


MongoDB使用：


使用mongodb存储房源信息：


当聊天对象不在线时将聊天信息发送到MQ,这里选用rocketMQ作为消息队列。

导入依赖以及进行配置：


RocketMQ的使用：


使用redis:
导入redis依赖以及配置，采用集群部署


RedisConfig文件：


RedisTemplate的使用：



用Elasticsearch做房源搜索
导入包以及配置：


Elasticsearch的使用：



搭建后台myql数据库：

使用docker进行安装MySQL集群：



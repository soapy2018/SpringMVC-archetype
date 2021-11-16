#set( $P = '#' )
$P$P ${rootArtifactId}
业务服务说明，[confluence](http://confluence.bluetron.cn/)


$P$P 项目说明

* ${rootArtifactId}-service 
  
   1. 后台核心服务 <br>
   2. 端口：
  
* ${rootArtifactId}-api

  api 客户端，包括DTO,枚举，客户端调用等
  

$P$P 项目结构
 
```
${rootArtifactId}
│ 
├─${rootArtifactId}-service  服务后台
│    ├─src/main/java  模块
│    │       ├─common    常量配置
│    │       ├─dao       dao 层
│    │       ├─entity    entity 层
|    |       ├─exception 异常 
|    |       ├─manager   manager 层
|    |       ├─utils     工具类
|    |       ├─controller controller层
|    |       └─handler    handler层
│    │ 
│    └─src/main/resources 
│        ├─sql                 数据库初始化文件
│        ├─i18n               国际化翻译文件
│        └─application.yml 全局配置文件
│       
│ 
├─${rootArtifactId}-api   API服务
|    ├─client   client 客户端调用,对外暴露的openFeign接口  
|    ├─DTO      DTO 数据传输对象
|    ├─enums    枚举类
|    └─service  定义了api接口
|
│ 
```

$P$P 启动
 
 * 基于appliccation 类启动
   
   >  配置jvm 参数：-Dspring.profiles.active=dev
 * 基于springBoot maven 插件

   > spring-boot:run -Dspring-boot.run.profiles=dev
 * IDEA 以类的main方式启动
  
   > 添加启动参数：--spring.profiles.active=dev


$P$P 依赖说明
`依赖详细使用方式请见各项目地址`

|功能|Maven坐标|项目地址|项目地址|
|---|---|---|---|
|supOS SDK|com.bluetron.sdk:bluetron-java-sdk|http://gitlab.nb.bluetron.cn/bluetron-app-middle/bluetron-app-middle-sdk|封装了supOS鉴权、用户、对象等部分接口|
|supOS SDK starter|com.bluetron.app:bluetron-app-starter-sdk|http://gitlab.nb.bluetron.cn/bluetron-app-starter/bluetron-app-starter-sdk|supOS SDK starter|
|缓存|com.bluetron.app:bluetron-app-middle-cache|http://gitlab.nb.bluetron.cn/bluetron-app-middle/bluetron-app-middle-cache|封装了redis|
|表达式计算|com.bluetron.app:bluetron-app-middle-calculation|http://gitlab.nb.bluetron.cn/bluetron-app-middle/bluetron-app-middle-calculation|表达式计算|
|国际化|com.bluetron.app:bluetron-app-common-i18n|http://gitlab.nb.bluetron.cn/bluetron-app/bluetron-app-common-i18n|提供国际化消息转换|
|公共对象方法|com.bluetron.app:bluetron-app-common-basic|http://gitlab.nb.bluetron.cn/bluetron-app/bluetron-app-common-basic|静态常量，异常，公共对象，工具等|
|编码服务|com.bluetron.app:middle-code-service-mongo|http://gitlab.nb.bluetron.cn/bluetron-app-middle/bluetron-app-middle-code|基于mongoDB实现的编码服务|
|App autoconfigure|com.bluetron.app:bluetron-app-common-autoconfigure|http://gitlab.nb.bluetron.cn/bluetron-app/bluetron-app-common-autoconfigure|app自动配置，异常拦截，全局SpringContextHolder,Web日志拦截等|
|数据库配置|com.bluetron.app:bluetron-app-common-database|http://gitlab.nb.bluetron.cn/bluetron-app/bluetron-app-common-database|Mybatis数据库配置|

$P$P 代码生成工具
    本工程代码基本由代码生成器自动完成，因此建议了解其使用方法。见[代码生成工具](http://gitlab.nb.bluetron.cn/shiming/bluetron-app-backend-auto-code-generator)

本项目创建自[SpringMVC-archetype](http://gitlab.nb.bluetron.cn/bluetron-framework/SpringMVC-archetype)

$P$P arthas
```shell script
docker exec -it $(docker ps|grep ${rootArtifactId}-service|grep java|awk '{print $1}') /bin/sh -c "wget -O/dev/null http://192.168.8.74/tool/arthas/arthas-bin.tar && tar -vxf arthas-bin.tar >dev/null && java -jar ./arthas-bin/arthas-boot.jar"
```

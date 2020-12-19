# Vegetable_Mall 购物商城
# 简单介绍
本项目使用Spring+SpringMVC+Mybatis+thymeleaf来实现了一个网上商城系统，可以使用maven构建为war包进行部署，也可部署在Tomcat中运行。
# 开发环境
      jdk 1.8,mysql 5.7.26,window 10 1903,idea 2020.1
# 本地开发运行部署
      环境准备：
      idea、mysql
      下载 zip 直接解压或安装 git 后执行克隆命令 https://github.com/qsj-kiss/Vegetable_Mall.git
      在 MySQL 中创建数据库 Vegetable_Mall
      导入项目至 IDEA，将工程中的 Vegetable_Mall.sql导入 MySQL
      将shop文件夹放置到项目外，在Tomcat配置中将shop文件夹中的images配置进去路径名设置为pubimages，文件夹位置具体修改utils中的UploadUtil.java文件
      需要使用邮箱功能需要再email.properties中自行配置
      项目日志文件默认写入shop文件夹中的logs文件夹中（具体位置也需要在log4j.properties文件中修改）
      项目启动默认地址为:http://localhost:8080
# 主要功能
  ## 1.普通用户
      登录、注册功能
      浏览商品功能
      修改用户功能	
      搜索商品功能
      查看商品详情
      添加购物车
      购买功能（购物车批量购买）
      查看订单状态
      删除订单功能
  ## 2.管理员
       查看、禁用所有用户功能
       查看、禁用所有商品功能
       查看、禁用所有订单功能
       添加新的商品功能
       修改商品的功能（商品名称，库存，商品描述，类型，是否热卖）
       处理订单功能（付款，发货，禁用）
# 默认用户
   ## 1.Admin 
      usernam=qsj
      password=123
   ## 2.User
      username=qsj
      password=qwe123
  

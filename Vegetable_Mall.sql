/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.26 : Database - vegetable_mall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vegetable_mall` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `vegetable_mall`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `a_username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `a_password` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `admin` */

insert  into `admin`(`a_username`,`a_password`) values ('qsj','123');

/*Table structure for table `description` */

DROP TABLE IF EXISTS `description`;

CREATE TABLE `description` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_remark` varchar(50) NOT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `description` */

insert  into `description`(`d_id`,`d_remark`) values (2,'肉类'),(3,'水果'),(4,'蔬菜'),(6,'乳制品');

/*Table structure for table `dictionaries` */

DROP TABLE IF EXISTS `dictionaries`;

CREATE TABLE `dictionaries` (
  `originalname` varchar(50) NOT NULL,
  `actualname` varchar(50) NOT NULL,
  `remark` varchar(200) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `dictionaries` */

insert  into `dictionaries`(`originalname`,`actualname`,`remark`,`id`) values ('orders','订单表','用于存放用户产生的订单',1),('user','用户表','用于存放用户的数据',2),('description','货物表','用于管理各个货物',3),('protuct','货物数据表','用于存储货物的详细信息',4),('date+id+gwc','购物车表','用于存放用户的购物车信息(命名规则为:当前时间+用户id+gwc）',5),('o_id','订单id','用于指定订单id',6),('u_id','用户id','用于指定用户id',7),('totalmoney','价格总和','用于统计订单价格总和',8),('address','地址信息','用于存储用户的地址信息',9),('state','订单状态','用于指定订单当前状态(默认值为1,1为正常,0为已报废)',10),('create_time','创建时间','用于显示订单的创建时间',11),('email','邮箱','用于存储用户的邮箱信息',13),('u_name','用户名','用于存储用户的用户名',14),('u_password','密码','用于存储用户的密码',15),('u_phone','电话号码','用于存储用户的电话号码',16),('remark','备注','用于存储用户的其他备注信息（vip）',17),('gender','姓名','用于存储用户的性别数据（男，女，null）',18),('price','价格','用于存储货物的单价',19),('description_id','货物id','用于存储货物的唯一id',20),('p_overView','货物概述','用于解释货物的种类',21),('oredr_details','订单详情表','用于存储用户的订单详情数据',22),('od_id','订单详情表id','用于存储货物的详情信息的id',23),('p_id','货物id','用于显示货物的id',24),('od_count','货物的数量','用于存储详细订单中货物的数量',25),('p_inventory','货物的库存','用于显示货物的库存数量',26);

/*Table structure for table `order_details` */

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `od_id` varchar(50) NOT NULL,
  `p_id` int(11) NOT NULL,
  `od_count` int(11) NOT NULL,
  PRIMARY KEY (`p_id`,`id`),
  KEY `p_id` (`p_id`),
  KEY `id` (`id`),
  KEY `od_id` (`od_id`),
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`od_id`) REFERENCES `orders` (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

/*Data for the table `order_details` */

insert  into `order_details`(`id`,`od_id`,`p_id`,`od_count`) values (42,'2020120801221607361735275',21,1),(55,'2020120813391607405987039',21,4),(58,'2020120922371607524674809',21,1),(64,'2020121109281607650081729',21,3),(72,'2020121113361607665003798',21,3),(43,'2020120801221607361735275',22,1),(54,'2020120813391607405987039',22,2),(57,'2020120922371607524674809',22,1),(60,'2020121002371607539053426',22,1),(63,'2020121002431607539401093',22,5),(65,'2020121109281607650081729',22,1),(70,'2020121111521607658728303',22,1),(79,'2020121510511608000708425',22,1),(83,'2020121514161608012982799',22,1),(85,'2020121723531608220429556',22,2),(89,'2020122000121608394374863',22,1),(31,'2020120721481607348938772',23,2),(71,'2020121113361607665003798',23,2),(76,'2020121509501607997045169',23,5),(48,'2020120801581607363893206',24,1),(51,'2020120802091607364588120',24,1),(80,'2020121510511608000708425',24,1),(88,'2020122000121608394374863',24,3),(32,'2020120721481607348938772',25,1),(49,'2020120801581607363893206',26,1),(52,'2020120802121607364769448',26,1),(56,'2020120813391607405987039',26,1),(61,'2020121002371607539053426',26,1),(59,'2020121002371607539053426',27,1),(69,'2020121111521607658728303',27,1),(78,'2020121510511608000708425',27,1),(62,'2020121002431607539401093',28,1),(66,'2020121109281607650081729',28,1),(81,'2020121510511608000708425',28,1),(75,'2020121509501607997045169',29,2),(50,'2020120802091607364588120',31,20),(82,'2020121510511608000708425',31,1),(44,'2020120801291607362147763',35,1),(46,'2020120801331607362419627',35,1),(68,'2020121111491607658595780',35,1),(74,'2020121116571607677072983',35,20),(84,'2020121514581608015522654',35,11),(45,'2020120801291607362147763',37,1),(47,'2020120801331607362419627',37,1),(53,'2020120802121607364769448',37,1),(67,'2020121111491607658595780',37,1),(73,'2020121113481607665701065',37,1),(77,'2020121510511608000708425',38,1),(86,'2020121815301608276633466',41,9),(87,'2020121815331608276803785',41,3);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `o_id` varchar(50) NOT NULL,
  `u_id` int(11) NOT NULL,
  `totalmoney` double NOT NULL,
  `address` varchar(100) NOT NULL,
  `telephone` varchar(25) NOT NULL,
  `paystate` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `Destate` int(2) NOT NULL DEFAULT '0',
  `state` int(2) NOT NULL DEFAULT '0',
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`o_id`,`u_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`o_id`,`u_id`,`totalmoney`,`address`,`telephone`,`paystate`,`create_time`,`Destate`,`state`,`username`) values ('2020120721481607348938772',3,300,'123','15116156647',1,'2020-12-07 21:48:59',0,1,'王新月'),('2020120801221607361735275',3,8,'123','15116156647',1,'2020-12-08 01:22:15',0,1,'王新月'),('2020120801291607362147763',3,246,'123','15116156647',0,'2020-12-08 01:29:08',0,1,'王新月'),('2020120801331607362419627',3,246,'123','15116156647',1,'2020-12-08 01:33:40',0,1,'王新月'),('2020120801581607363893206',3,11,'123','15116156647',1,'2020-12-08 01:58:13',0,1,'王新月'),('2020120802091607364588120',3,45,'湖南省长沙市望城区白箬铺镇光明村','13380764856',1,'2020-12-08 02:09:48',0,1,'王新月'),('2020120802121607364769448',3,129,'123','15116156647',1,'2020-12-08 02:12:49',0,1,'王新月'),('2020120813391607405987039',3,28,'湖南长沙','15116156647',1,'2020-12-08 13:39:47',0,1,'王新月'),('2020120922371607524674809',3,8,'123','15116156647',0,'2020-12-09 22:37:55',0,1,''),('2020121002371607539053426',3,17,'123','15116156647',1,'2020-12-10 02:37:33',0,1,'王新月'),('2020121002431607539401093',3,30,'2222','1231231231231232',1,'2020-12-10 02:43:21',0,0,'陈志强'),('2020121109281607650081729',3,19,'123','15116156647',1,'2020-12-11 09:28:02',0,0,'陈志强'),('2020121111491607658595780',3,246,'123','15116156647',1,'2020-12-11 11:49:56',0,0,'王新月'),('2020121111521607658728303',3,11,'123','15116156647',1,'2020-12-11 11:52:08',0,0,'王新月'),('2020121113361607665003798',3,15,'123','15116156647',1,'2020-12-11 13:36:44',0,0,'王新月'),('2020121113481607665701065',3,123,'123','15116156647',1,'2020-12-11 13:48:21',0,0,'王新月'),('2020121116571607677072983',1,2460,'湖南长沙','15116156648',1,'2020-12-11 16:57:53',0,0,'秦世交'),('2020121509501607997045169',3,21,'123','15116156647',1,'2020-12-15 09:50:45',0,0,'王新月'),('2020121510511608000708425',3,35,'123','15116156647',1,'2020-12-15 10:51:48',0,0,'王新月'),('2020121514161608012982799',3,5,'123','15116156647',1,'2020-12-15 14:16:23',0,0,'王新月'),('2020121514581608015522654',3,1353,'123','15116156647',0,'2020-12-15 14:58:43',0,0,'王新月'),('2020121723531608220429556',3,10,'湖南长沙望城区白箬铺镇光明村蝴蝶谷','15116156647',1,'2020-12-17 23:53:50',0,0,'王新月'),('2020121815301608276633466',3,801,'湖南长沙望城区白箬铺镇光明村蝴蝶谷','15116156647',1,'2020-12-18 15:30:33',0,1,'王新月'),('2020121815331608276803785',3,267,'湖南长沙望城区白箬铺镇光明村蝴蝶谷','15116156647',1,'2020-12-18 15:33:24',1,0,'王新月'),('2020122000121608394374863',3,20,'湖南长沙望城区白箬铺镇光明村蝴蝶谷','15116156647',1,'2020-12-20 00:12:55',0,0,'王新月');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(50) NOT NULL,
  `p_price` double NOT NULL,
  `p_date` datetime NOT NULL,
  `p_inventory` int(20) NOT NULL,
  `p_overview` varchar(200) DEFAULT NULL,
  `d_id` int(11) NOT NULL,
  `p_image` varchar(200) DEFAULT NULL,
  `p_state` int(1) NOT NULL,
  `p_isHot` int(11) NOT NULL,
  PRIMARY KEY (`p_id`,`d_id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`d_id`) REFERENCES `description` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`p_id`,`p_name`,`p_price`,`p_date`,`p_inventory`,`p_overview`,`d_id`,`p_image`,`p_state`,`p_isHot`) values (21,'桃子',3,'2020-11-29 22:12:31',325,'鲜美多汁',3,'202011292212316.jpg',1,1),(22,'青橙子',5,'2020-11-29 22:13:20',84,'水汪汪',3,'202011292213207.jpg',1,1),(23,'辣椒',3,'2020-11-29 22:13:41',3,'打开你的味蕾',4,'202011292213418.jpg',1,1),(24,'草莓',5,'2020-11-29 22:14:38',94,'美味多汁',3,'202011292214379.jpg',1,1),(25,'香菜',5,'2020-11-29 22:14:58',992,'多吃多消化',4,'2020112922145710.jpg',1,1),(26,'橙子',6,'2020-11-29 22:15:41',96,'水汪汪的橙子',3,'2020112922154111.jpg',1,1),(27,'梨子',6,'2020-11-29 22:16:05',97,'美味的梨子',3,'2020112922160412.jpg',1,0),(28,'西红柿',5,'2020-11-29 22:16:21',120,'下饭必备西红柿',3,'2020112922162113.jpg',1,0),(29,'菠萝',3,'2020-11-29 22:16:38',121,'波波波',3,'2020112922163814.jpg',1,0),(30,'包菜',3,'2020-11-29 22:17:02',1231,'包菜',4,'2020112922170216.jpg',1,0),(31,'红辣椒',2,'2020-11-29 22:17:18',210,'新鲜的辣椒',4,'2020112922171717.jpg',1,0),(32,'花菜',2,'2020-11-29 22:17:35',1229,'123123',4,'2020112922173418.jpg',1,0),(33,'胡萝卜',3,'2020-11-29 22:17:55',123,'123123',4,'2020112922175519.jpg',1,0),(34,'桃子',5,'2020-11-29 22:18:16',12311,'123123123',3,'2020112922181520.jpg',1,0),(35,'澳洲牛肉54555',123,'2020-11-29 22:34:33',10,'12',2,'2020112922343225.jpg',0,0),(37,'牛肉',123,'2020-12-06 15:20:10',119,'12313',2,'2020120615201013.jpg',0,0),(38,'美洲牛肉',12,'2020-12-11 11:10:48',11,'1212',2,'2020121111104722.jpg',0,0),(39,'安慕希牛奶',48,'2020-12-15 11:59:31',100,'味道好极了',6,'202012151159301.jpg',1,0),(40,'特仑苏牛奶',45,'2020-12-15 12:00:06',100,'有机纯牛奶',6,'202012151200052.jpg',1,0),(41,'Vega纯牛奶',89,'2020-12-15 12:01:05',40,'高温杀菌保护你我',6,'202012151201043.jpg',1,0),(42,'德亚纯牛奶',45,'2020-12-15 12:01:43',100,'德国原厂纯牛奶',6,'202012151201424.jpg',1,0),(43,'娃哈哈AD钙',12,'2020-12-15 12:02:19',100,'娃哈哈',6,'202012151202195.jpg',1,0),(44,'雀巢全脂牛奶',25,'2020-12-15 12:03:11',100,'源自香醇鲜牛奶',6,'202012151203106.jpg',1,0),(45,'旺旺牛奶',25,'2020-12-15 12:04:19',100,'你旺我旺大家旺',6,'202012151204187.jpg',1,0),(46,'西先牛奶',50,'2020-12-15 12:05:18',100,'',6,'202012151205188.jpg',1,0),(47,'简醇鲜牛奶',3,'2020-12-15 12:08:44',100,'不尖酸，不涩苦，奶味重',6,'202012151208449.jpg',1,0),(48,'特仑苏纯牛奶',120,'2020-12-15 12:09:15',100,'1',6,'2020121512091510.jpg',1,0),(49,'澳洲牛肉',123,'2020-12-18 17:16:44',123,'123',2,'2020121817164310.jpg',1,0),(50,'五花腊肉',32,'2020-12-19 22:00:04',100,'四川特产腊肉正宗 农家自制老烟熏肉咸五花肉5斤风干腊肠贵州湖南',2,'202012192200041.jpg',1,0),(51,'澳洲牛腱子',249,'2020-12-19 22:01:11',50,'恒都原切澳洲牛腱子5斤进口牛腱肉健身牛肉',2,'202012192201112.jpg',1,0),(52,'烟熏五花腊肉',36,'2020-12-19 22:02:09',50,'陈二洋 正宗四川烟熏五花腊肉熏肉5斤农家自制特产老咸肉湖南贵州',2,'202012192202093.jpg',1,0),(53,'牛腿肉',89,'2020-12-19 22:03:09',300,'进口牛肉新鲜冷冻生鲜牛腿肉健身烧烤非现杀牛腱子金钱腱芯',2,'202012192203094.jpg',1,1),(54,'柴火烟熏腊肉',38,'2020-12-19 22:04:29',200,'四川正宗特产农家自制柴火烟熏腊肉 5斤装川味腊肠老咸肉五花腊肉',2,'202012192204285.jpg',1,1),(55,'农家散养老母鸡',138,'2020-12-19 22:05:44',50,'老母鸡土鸡农家散养正宗走地鸡月子鸡笨鸡鲜鸡肉新鲜整只现杀冷冻',2,'202012192205436.jpg',1,0),(56,'六和鸡胸肉',128,'2020-12-19 22:06:51',50,'六和鸡胸肉20斤冷冻去皮非即食代餐鸡肉新鲜健身食品鸡脯肉鸡大胸',2,'202012192206507.jpg',1,0),(57,'土楼泡鸭爪',10,'2020-12-19 22:07:51',1000,'比比赞龙岩土楼泡鸭爪福建特产香脆鸭掌辣味零食小吃休闲卤味食品',2,'202012192207508.jpg',1,0),(58,'新鲜鸭舌',80,'2020-12-19 22:09:28',250,'大号新鲜鸭舌生鲜卤鸭货生冷冻鸭肉食材零食散装商用批发',2,'202012192209279.jpg',1,0),(59,'新鲜羊排',350,'2020-12-19 22:11:18',52,'新鲜羊排羊蝎子内蒙古半只羊腿烧烤火锅食材整只冷冻',2,'2020121922111810.jpg',1,0),(60,'呼伦贝尔羊肉',190,'2020-12-19 22:12:27',100,'内蒙古呼伦贝尔羊肉新鲜3斤去骨羊腿肉速冻生鲜',2,'2020121922122711.jpg',1,0),(61,'唻美蟹味棒',25,'2020-12-19 22:20:14',1000,'韩国客唻美蟹味棒蟹肉即食手撕蟹柳火锅用食材低脂寿司海味零食品',2,'2020121922201412.jpg',1,0),(62,'澳洲牛肉2',121,'2020-12-20 00:34:54',111,'',2,'202012200034547.jpg',0,0);

/*Table structure for table `shop_cart` */

DROP TABLE IF EXISTS `shop_cart`;

CREATE TABLE `shop_cart` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  `p_count` int(11) NOT NULL,
  PRIMARY KEY (`sc_id`),
  KEY `pk_sc_user` (`u_id`),
  KEY `pk_sc_pro` (`p_id`),
  CONSTRAINT `pk_sc_pro` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  CONSTRAINT `pk_sc_user` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `shop_cart` */

insert  into `shop_cart`(`sc_id`,`u_id`,`p_id`,`p_count`) values (21,1,37,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(10) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `gender` char(5) NOT NULL DEFAULT '男',
  `phone` varchar(30) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT '会员',
  `email` varchar(50) NOT NULL,
  `state` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`u_id`,`phone`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_name`,`u_password`,`gender`,`phone`,`address`,`remark`,`email`,`state`) values (1,'qsj','200820e3227815ed1756a6b531e7e0d2','男','15116156666','湖南长沙开福区','会员','847352186@qq.com',0),(3,'wxy','e10adc3949ba59abbe56e057f20f883e','女','18569537777','湖南长沙望城区','会员','1343922182@qq.com',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

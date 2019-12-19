/*
SQLyog v10.2 
MySQL - 5.5.50 : Database - pet mall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pet mall` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pet mall`;

/*Table structure for table `adminuser` */

DROP TABLE IF EXISTS `adminuser`;

CREATE TABLE `adminuser` (
  `auid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`auid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `adminuser` */

insert  into `adminuser`(`auid`,`username`,`password`,`uid`) values (1,'admin','admin',0);

/*Table structure for table `billitem` */

DROP TABLE IF EXISTS `billitem`;

CREATE TABLE `billitem` (
  `billid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `ptotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`billid`),
  UNIQUE KEY `pid` (`pid`),
  KEY `FK3510439A73B4E627` (`pid`),
  CONSTRAINT `FK3510439A73B4E627` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `billitem` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`) values (1,'宠物狗'),(2,'宠物猫'),(3,'宠物兔'),(4,'宠物鸟类'),(5,'宠物鱼类'),(6,'其他宠物'),(14,'驴');

/*Table structure for table `categorysecond` */

DROP TABLE IF EXISTS `categorysecond`;

CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `FK936FCAF2418BCBAF` (`cid`),
  CONSTRAINT `FK936FCAF2418BCBAF` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `categorysecond` */

insert  into `categorysecond`(`csid`,`csname`,`cid`) values (1,'金毛犬',1),(2,'牧羊犬',1),(3,'哈士奇犬',1),(4,'阿拉斯加',1),(5,'拉布拉多',1),(6,'其他犬类',1),(7,'加菲猫',2),(8,'波斯猫',2),(9,'巴厘猫',2),(10,'龙猫',2),(11,'布偶猫',2),(13,'猫咪',2),(14,'其他猫',2),(15,'白兔',3),(16,'蝴蝶兔',3),(17,'荷兰兔',3),(18,'猫猫兔',3),(19,'鹦鹉',4),(20,'金丝雀',4),(21,'百灵鸟',4),(22,'喜鹊',4),(23,'金鱼',5),(24,'龙鱼',5),(25,'热带鱼',5),(29,'玻璃鱼',5),(30,'宠物猪',6),(31,'宠物猴',6),(32,'宠物鳄鱼',6),(33,'宠物鼠',6);

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `messageid` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `messagedate` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`messageid`),
  KEY `FK38EB0007FC32F8E` (`uid`),
  CONSTRAINT `FK38EB0007FC32F8E` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`messageid`,`message`,`messagedate`,`uid`) values (1,'这个宠物商城中的宠物都好可爱','2018-11-28',3),(2,'\r\n哈士奇真是太可爱了，哈哈','2018-11-28',3),(3,'阿萨苏打水','2019-12-05 15:31:51',1),(15,'啊打撒十大大苏打','2019-12-19 09:39:30',1),(16,'好可爱啊啊啊啊啊啊','2019-12-19 09:39:57',1);

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `oiid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oiid`),
  KEY `FKE8B2AB61E818A405` (`oid`),
  KEY `FKE8B2AB6173B4E627` (`pid`),
  CONSTRAINT `FKE8B2AB6173B4E627` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `FKE8B2AB61E818A405` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`oiid`,`count`,`subtotal`,`pid`,`oid`) values (1,1,699,36,2),(2,1,588,37,2),(3,1,699,42,2),(4,1,699,40,2),(5,1,4899,54,3),(6,1,7999,55,3),(7,1,45,45,3),(8,1,9,46,3),(23,1,500,60,3),(48,100,50000,60,55),(49,10,2450,40,54),(61,1,166,61,62);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `money` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `receiveInfo` varchar(255) DEFAULT NULL,
  `phoNum` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `accepter` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E5FC32F8E` (`uid`),
  CONSTRAINT `FKC3DF62E5FC32F8E` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`money`,`state`,`receiveInfo`,`phoNum`,`order_time`,`uid`,`accepter`) values (2,2685,1,'上海市静安区','13913812312','2018-03-18 21:12:16',3,'嗷大猫'),(3,12952,3,NULL,NULL,'2018-03-04 17:37:01',1,NULL),(54,83000,3,NULL,NULL,'2019-12-11 07:11:55',1,NULL),(55,1332,0,NULL,NULL,'2019-12-11 07:19:23',1,NULL),(62,166,3,'河南省信阳市','15565540886','2019-12-11 08:54:51',1,'周相宾');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdesc` varchar(5000) DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdate` timestamp NULL DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKED8DCCEF5F778050` (`csid`),
  CONSTRAINT `FKED8DCCEF5F778050` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`pid`,`pname`,`market_price`,`shop_price`,`image`,`pdesc`,`is_hot`,`pdate`,`csid`,`state`) values (34,'阿拉斯加',422,399,'products/0ad46e8a-1807-416a-96bb-c6ce04afd5ff0004.jpg','霸气阿拉斯加',1,'2018-12-13 17:38:24',4,NULL),(35,'金丝雀',110,99,'products/1dcf0d68-5717-448e-816e-7ebf65e9583a20181122062410.jpg','金丝雀，唱歌很好听',1,'2018-12-13 17:37:12',20,NULL),(36,'小白兔',470,450,'products/dea43f3c-6f85-42bb-bbe8-37406d55f34f1001.jpg','小白兔，白又白，\r\n两只耳朵竖起来',0,'2018-12-13 17:36:29',15,NULL),(37,'鹦鹉鸟',209,188,'products/216c0eaf-3f94-4f91-8fe0-484f764622c21000.jpg','会说话的鹦鹉',0,'2018-12-13 17:35:46',19,NULL),(38,'可爱小鼠',199,100,'products/ad6a2586-81a0-4d0c-94a3-396fc183a8d5laoshu.jpg','可爱小老鼠',0,'2018-12-13 17:35:08',33,NULL),(39,'可爱波斯猫',169,133,'products/63f09645-c7a1-4834-a6ff-e3731a7b51f820181122063109.jpg','十分好看的波斯猫',1,'2018-12-13 17:34:11',8,NULL),(40,'金毛犬',290,245,'products/78877fdc-41ae-4646-9bae-c5fe968679ce20181209024808.jpeg','听话暖男金毛犬',1,'2018-12-13 17:33:36',1,NULL),(41,'加菲猫',770,555,'products/b27b1e23-494c-4be8-a39f-4913e21300e420181122064535.jpg','高冷加菲猫',1,'2018-12-13 17:32:25',7,NULL),(42,'蝴蝶犬',180,150,'products/daeca39f-da98-43ef-925d-ecf247ff361220181122064621.jpg','十分惹人爱的蝴蝶犬',0,'2018-12-13 17:31:28',6,NULL),(43,'比特犬',220,160,'products/40cc2f0f-d292-4acd-885a-a9a2e8f7a57f20181122064717.jpg','十分凶悍',0,'2018-12-13 17:30:40',6,NULL),(44,'可爱小猫咪',290,245,'products/ee9a02c6-c463-4872-9c39-6552abf2a1a020181123092208.jpg','可爱小猫咪',1,'2018-12-13 17:29:44',13,NULL),(45,'小金鱼',190,120,'products/aa8949d9-083f-4a48-8772-5fe5524095d720181122064917.jpg','金色小金鱼',1,'2018-12-13 17:28:38',23,NULL),(46,'龙猫',111,90,'products/9fb10bd1-9ebc-4068-97a5-ef32fda557290008.jpg','龙猫',1,'2018-12-13 17:48:08',10,NULL),(47,'哈士奇犬',299,289,'products/eeaaada5-99a8-4d40-ad0d-076deeba151f0003.jpg','俗称（二哈）哈士奇犬',1,'2018-12-13 17:44:29',3,NULL),(48,'蝴蝶兔',522,419,'products/bba102ca-3699-4a6b-8d04-a0879b95aa3fu=3523400314,1092009656&fm=58&bpow=250&bpoh=177.jpg','蝴蝶兔',0,'2018-12-13 17:59:45',16,NULL),(49,'牧羊犬',1299,1199,'products/2c339cce-8e9e-462a-ba75-2633be204ea60002.jpg','牧羊犬幼犬',0,'2018-12-13 17:43:13',2,NULL),(50,'巴厘猫',199,189,'products/1e4a6123-962d-422a-b3d9-713cf917f24e0007.jpg','巴厘猫幼猫',0,'2018-12-13 17:45:54',9,NULL),(51,'热带鱼',1199,1099,'products/d7271709-f0f7-438c-b914-80d226f95687u=585336170,3913415700&fm=58.jpg','热带鱼，煮着吃十分美味',1,'2018-12-13 17:58:32',25,NULL),(52,'龙鱼',1999,1799,'products/dd515ca6-7e9e-429a-99c8-ead0d4f41aa8u=946221869,1962949722&fm=58.jpg','红尾龙鱼',0,'2018-12-13 17:50:54',24,NULL),(53,'猫猫兔',159,109,'products/75247e27-809f-47b9-82a1-4a8122045d80u=831971558,1559669327&fm=58&bpow=600&bpoh=600.jpg','猫猫兔',0,'2018-12-13 18:01:25',18,NULL),(54,'小猫咪',700,500,'products/5fab14f2-2532-4529-90b0-6e65b2bf4feb20181122062127.jpg','小猫咪',1,'2018-12-13 17:24:54',13,NULL),(55,'荷兰兔',800,600,'products/e8a206cc-006d-4232-9398-f8f227ae0e7d20181122062010.jpg','荷兰兔',0,'2018-12-13 17:22:48',17,NULL),(56,'百灵鸟',166,144,'products/ef7c9826-733d-4eae-aeef-9d7382906ddcu=2032935164,2077203867&fm=58&bpow=700&bpoh=489.jpg','百灵鸟声音极其好听',1,'2018-12-13 18:02:50',21,NULL),(57,'宠物猪',555,444,'products/7103de05-ed39-4cb2-842a-660303933c20u=1307429950,572500159&fm=27&gp=0.jpg','宠物猪，长不大，也就能长到300斤',1,'2018-12-13 18:04:52',30,NULL),(58,'宠物猴',644,500,'products/a4f0db6a-e18a-4182-9992-c09d77b1cdb1u=3068668599,2651578214&fm=58&bpow=450&bpoh=300.jpg','宠物猴，长得十分聪明',1,'2018-12-13 18:07:04',31,NULL),(59,'宠物鳄鱼',944,700,'products/b6b37dba-6ab0-4156-b434-f71ebac649c6c75c10385343fbf2849eb1b1bb7eca8064388ff5.jpg','宠物鳄鱼',1,'2018-12-13 18:09:15',32,NULL),(60,'母金毛犬',599,500,'products/60849188-8f40-4d69-ab2f-15102fcaaebe0001.jpg','母的金毛犬',1,'2018-12-13 18:36:00',1,NULL),(61,'布偶猫',199,166,'products/df32868a-fd63-44b9-9a71-4df3ef83c3d2u=861903154,2429196093&fm=27&gp=0.jpg','布偶猫',1,'2018-12-13 18:37:18',11,NULL);

/*Table structure for table `shopcartitem` */

DROP TABLE IF EXISTS `shopcartitem`;

CREATE TABLE `shopcartitem` (
  `cartitemid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `pcount` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `ptotal` double DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cartitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shopcartitem` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `state` int(255) NOT NULL DEFAULT '1',
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`name`,`email`,`phone`,`addr`,`state`,`code`) values (1,'b','b','李佳','lijia@qq.com','15137226422','安阳市',0,NULL),(3,'hellokitty','123456','张三','aodamao@qq.com','13555512345','上海市',0,'ca0f6f5a-36da-402d-8c0f-22587423de20'),(4,'a','a','a','a','a','a',0,'a'),(5,'ss','ss','周','2976645493@qq.com','15565540886','深圳',0,'8bdafe47-ba7b-402d-9d1b-bbf16a95fda8'),(6,'as','as','as','as','as','as',0,'a9c313bf-a89b-434d-b2ef-1e83eaebe740'),(13,'aa','zx','嗯嗯','2976645493@qq.com','15565540886','深圳',0,'57dcf2b9-ce1a-43c2-b8d3-a99b0a6765bc');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

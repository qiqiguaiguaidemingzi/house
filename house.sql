# Host: localhost  (Version 5.5.22)
# Date: 2018-04-25 10:34:11
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "admin"
#

CREATE TABLE `admin` (
  `manager` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  PRIMARY KEY (`manager`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES ('xxx','137XXXX110'),('yyy','137XXXX120'),('zzz','137XXXX119');

#
# Structure for table "userinfo"
#

CREATE TABLE `userinfo` (
  `acc` varchar(15) NOT NULL,
  `psd` varchar(15) NOT NULL,
  `realName` varchar(15) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`acc`),
  UNIQUE KEY `acc` (`acc`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Data for table "userinfo"
#

INSERT INTO `userinfo` VALUES ('04151501','123','无名','1111111111@qq.com'),('04151502','123','林先生','1282675158@qq.com'),('11111111111','A123456','临时账户','123456@qq.com'),('13750004899','A123456','dog','154321@pp.com'),('13750033195','A123456','哈哈','1282675158@qq.com');

#
# Structure for table "houseinfo"
#

CREATE TABLE `houseinfo` (
  `houseNum` int(11) NOT NULL AUTO_INCREMENT,
  `houseName` varchar(20) NOT NULL,
  `price` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `area` varchar(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `type` varchar(20) NOT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `acc` varchar(15) NOT NULL,
  `manager` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`houseNum`),
  KEY `fk` (`acc`),
  KEY `manager` (`manager`),
  CONSTRAINT `fk` FOREIGN KEY (`acc`) REFERENCES `userinfo` (`acc`),
  CONSTRAINT `houseinfo_ibfk_1` FOREIGN KEY (`manager`) REFERENCES `admin` (`manager`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=gbk;

#
# Data for table "houseinfo"
#

INSERT INTO `houseinfo` VALUES (130,'中铁凤凰谷','5500','广东省珠海市香洲区横琴中央商务区','115','啊啊啊啊啊啊啊啊啊啊啊啊阿啊啊啊','3房2厅','1375003319515238413935710.jpg,1375003319515238413935861.jpg,1375003319515238413935862.jpg,1375003319515238413936023.jpg,1375003319515238413936024.jpg','13750033195','xxx',2),(131,'诚丰广场','2380','广东省珠海市香洲区明珠南路和岱山路','95','哈哈哈哈哈哈哈','2房2厅','1375003319515238415095950.jpg,1375003319515238415095951.jpg,1375003319515238415095952.jpg,1375003319515238415095953.jpg,1375003319515238415096104.jpg','13750033195','xxx',2),(132,'天一居','3400','广东省珠海市香洲区湾仔南湾南路','100','我也不知啊','6房3厅','1375000489915238416715650.jpg,1375000489915238416715691.jpg,1375000489915238416715732.jpg,1375000489915238416715753.jpg,1375000489915238416715754.jpg','13750004899','zzz',3),(133,'某某角落','1000000','广东省汕头市潮阳区某某地方','100000','我也不知道这地方在哪里，别相信图片！','7房7厅','1375000489915238417337240.jpg,1375000489915238417337271.jpg,1375000489915238417337312.jpg,1375000489915238417337353.jpg,1375000489915238417337394.jpg','13750004899','zzz',2),(134,'万科魅力之城','1800','广东省珠海市斗门区万科魅力之城','89','白蕉 万科魅力之城 全新精装 电梯3房 租金1800元\n\n新房，精装，电梯高层，看园景，游泳池，品牌楼盘，物业管理好。\n \n万科魅力之城房子户','1房3厅','1111111111115238418244660.jpg,1111111111115238418244701.jpg,1111111111115238418244732.jpg,1111111111115238418244733.jpg,1111111111115238418244734.jpg','11111111111','yyy',2),(141,'1','1','1','1',NULL,'1',NULL,'13750033195','yyy',1),(142,'1','1','1','1',NULL,'1',NULL,'13750033195','xxx',3),(144,'1','1','1','1',NULL,'1',NULL,'13750033195','yyy',1),(146,'天相聚','123456','广西省桂林市西区','1345','啦啦啦啦啦啦啦啦啦绿绿绿绿绿绿绿绿绿绿','9房4厅','1375000489915239549734510.jpg,1375000489915239549734931.jpg,1375000489915239549735002.jpg,1375000489915239549735103.jpg,1375000489915239549735174.jpg,1375000489915239549735255.jpg,1375000489915239549735336.jpg,1375000489915239549735397.jpg','13750004899','yyy',2);

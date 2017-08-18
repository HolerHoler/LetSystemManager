/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : letsystem

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-18 18:26:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for broker
-- ----------------------------
DROP TABLE IF EXISTS `broker`;
CREATE TABLE `broker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credentials_type` varchar(10) NOT NULL,
  `credentials_id` varchar(20) NOT NULL,
  `personName` varchar(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `work_address` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of broker
-- ----------------------------
INSERT INTO `broker` VALUES ('1', '身份证', '1233', '发', '02222120', '31');
INSERT INTO `broker` VALUES ('2', '身份证', '123461', '2', '02222121', '光华走1');
INSERT INTO `broker` VALUES ('3', '身份证', '123462', '22', '02222122', '光华走2');
INSERT INTO `broker` VALUES ('4', '身份证', '123463', '333', '02222123', '光华走3');
INSERT INTO `broker` VALUES ('5', '身份证', '123464', '发达', '02222124', '光华走4');
INSERT INTO `broker` VALUES ('6', '身份证', '123465', '发大水', '02222125', '光华走5');
INSERT INTO `broker` VALUES ('11', '护照', '333', '发', '42342', '翻');
INSERT INTO `broker` VALUES ('12', '军官证', '333', '发', '42342', '翻');
INSERT INTO `broker` VALUES ('13', '军官证', '2', '2', '2', '2');
INSERT INTO `broker` VALUES ('14', '护照', '1213', '21', '21', '21');
INSERT INTO `broker` VALUES ('15', '护照', '发', '发送', '翻啊', '发');
INSERT INTO `broker` VALUES ('17', '护照', 'fda ', '321', '321', '321');
INSERT INTO `broker` VALUES ('18', '护照', '顶顶顶', '放大', '方法', '发阿飞啊');
INSERT INTO `broker` VALUES ('19', '护照', '发阿飞啊', '发的', '发多发发', '发阿凡达');
INSERT INTO `broker` VALUES ('21', '军官证', 'ff', 'ff', 'ff', 'ff');
INSERT INTO `broker` VALUES ('22', '军官证', '淡淡的', 'ddd', 'ff', 'ff');
INSERT INTO `broker` VALUES ('23', '护照', 'ff', 'f', 'f', 'f');
INSERT INTO `broker` VALUES ('24', '护照', 'f', 'f', 'f', 'f');
INSERT INTO `broker` VALUES ('25', '户口本', '222', '22', '222', '2222');

-- ----------------------------
-- Table structure for brokerhouse
-- ----------------------------
DROP TABLE IF EXISTS `brokerhouse`;
CREATE TABLE `brokerhouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `broker_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf8ft7vhydanc3w9va8cs27u1y` (`broker_id`),
  KEY `FKid2691k9kmlv4j14wnpo4hiua` (`house_id`),
  CONSTRAINT `FKf8ft7vhydanc3w9va8cs27u1y` FOREIGN KEY (`broker_id`) REFERENCES `broker` (`id`),
  CONSTRAINT `FKid2691k9kmlv4j14wnpo4hiua` FOREIGN KEY (`house_id`) REFERENCES `houseinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brokerhouse
-- ----------------------------
INSERT INTO `brokerhouse` VALUES ('6', '5', '4');
INSERT INTO `brokerhouse` VALUES ('8', '5', '6');
INSERT INTO `brokerhouse` VALUES ('9', '5', '4');

-- ----------------------------
-- Table structure for houseinfo
-- ----------------------------
DROP TABLE IF EXISTS `houseinfo`;
CREATE TABLE `houseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `houseName` varchar(40) NOT NULL,
  `type` varchar(10) NOT NULL,
  `design` varchar(10) NOT NULL,
  `size` double NOT NULL,
  `rent` double DEFAULT NULL,
  `rent_method` varchar(4) NOT NULL,
  `rent_remand` varchar(4) NOT NULL,
  `direction` varchar(4) NOT NULL,
  `address` varchar(40) NOT NULL,
  `floor` varchar(8) NOT NULL,
  `decoration` varchar(8) NOT NULL,
  `facilities` longtext,
  `description` longtext,
  `state` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of houseinfo
-- ----------------------------
INSERT INTO `houseinfo` VALUES ('2', 'fff', '普通', '三房1', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州1', '5/6', '豪华', '', '海景房', 'N');
INSERT INTO `houseinfo` VALUES ('4', '画好3', '普通', '三房3', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州3', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('5', '画好4', '普通', '三房4', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州4', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('6', '呵呵', '普通', '三房5', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州5', '5/6', '豪华', '', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('8', '画好7', '普通', '三房7', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州7', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('11', '额', '普通', '2', '130', '1300', '3', 'fa ', '东南', '3', '3', '0', '电视', 'fa', 'N');
INSERT INTO `houseinfo` VALUES ('13', '发', '普通', '发', '130', '1234', '11', '11', '发大水', '嗯嗯', '嗯嗯额', '豪华', '电视, 空调, 家具', '12121', 'N');
INSERT INTO `houseinfo` VALUES ('14', 'fff', '别墅', 'fff', '122', '1340', 'fff', 'fff', 'ff', '222', '222', '0', '', '', 'N');
INSERT INTO `houseinfo` VALUES ('15', '方法', '普通', '发', '123', '200', '发达', '发', '发', '1212', '22', '精美', '', '', 'N');

-- ----------------------------
-- Table structure for letinfo
-- ----------------------------
DROP TABLE IF EXISTS `letinfo`;
CREATE TABLE `letinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `letName` varchar(15) NOT NULL,
  `house_id_let` int(11) DEFAULT NULL,
  `renter_id` int(11) DEFAULT NULL,
  `broker_id_let` int(11) DEFAULT NULL,
  `beginTime` date NOT NULL,
  `dayNum` int(11) NOT NULL,
  `endTime` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK945jyq2akvnp7js88tv6qcnj4` (`house_id_let`),
  KEY `FKaym61tfo1ht8crdjhtn7xcne6` (`renter_id`),
  KEY `FKnaxjv172p2o84ocfe0erw3eg4` (`broker_id_let`),
  CONSTRAINT `FK945jyq2akvnp7js88tv6qcnj4` FOREIGN KEY (`house_id_let`) REFERENCES `houseinfo` (`id`),
  CONSTRAINT `FKaym61tfo1ht8crdjhtn7xcne6` FOREIGN KEY (`renter_id`) REFERENCES `renter` (`id`),
  CONSTRAINT `FKnaxjv172p2o84ocfe0erw3eg4` FOREIGN KEY (`broker_id_let`) REFERENCES `broker` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of letinfo
-- ----------------------------
INSERT INTO `letinfo` VALUES ('3', '333', '6', '9', '5', '2017-08-16', '444', '2017-08-16');
INSERT INTO `letinfo` VALUES ('4', '高福帅', '6', '9', '5', '2017-08-11', '1', '2017-08-17');
INSERT INTO `letinfo` VALUES ('5', '分', '5', '4', '6', '2017-08-11', '1', '2017-08-03');
INSERT INTO `letinfo` VALUES ('6', '发222', '4', '4', '2', '2017-08-09', '15', '2017-08-27');
INSERT INTO `letinfo` VALUES ('9', '翻阿飞', '4', '3', '2', '2017-08-25', '333', '2017-08-20');
INSERT INTO `letinfo` VALUES ('10', 'ddd', '6', '6', '5', '2017-08-16', '3', '2017-08-16');

-- ----------------------------
-- Table structure for renter
-- ----------------------------
DROP TABLE IF EXISTS `renter`;
CREATE TABLE `renter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credentials_type` varchar(10) NOT NULL,
  `credentials_id` varchar(20) NOT NULL,
  `personName` varchar(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renter
-- ----------------------------
INSERT INTO `renter` VALUES ('1', '身份证', '123460', '方法', '02222120');
INSERT INTO `renter` VALUES ('2', '身份证', '123461', '方法', '02222121');
INSERT INTO `renter` VALUES ('3', '身份证', '123462', '方法', '02222122');
INSERT INTO `renter` VALUES ('4', '身份证', '123463', '方法', '02222123');
INSERT INTO `renter` VALUES ('6', '身份证', '123465', '都1', '02222125');
INSERT INTO `renter` VALUES ('7', '身份证', '123466', '发', '02222126');
INSERT INTO `renter` VALUES ('8', '身份证', '123467', '的', '02222127');
INSERT INTO `renter` VALUES ('9', '身份证', '123468', '等等', '02222128');
INSERT INTO `renter` VALUES ('10', '身份证', '123469', '133', '02222129');
INSERT INTO `renter` VALUES ('13', '护照', '淡淡的', '发', '发');
INSERT INTO `renter` VALUES ('14', '身份证', 'aaa', '发321', '111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Holer', '123456');

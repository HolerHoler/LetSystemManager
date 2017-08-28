/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : letsystem

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-28 13:58:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for broker
-- ----------------------------
DROP TABLE IF EXISTS `broker`;
CREATE TABLE `broker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `credentials_type` varchar(10) NOT NULL,
  `credentials_id` varchar(20) NOT NULL,
  `personName` varchar(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `work_address` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of broker
-- ----------------------------
INSERT INTO `broker` VALUES ('1', '身份证', '123460', 'Holer0', '02222120', '光华走0');
INSERT INTO `broker` VALUES ('2', '身份证', '123461', 'Holer1', '02222121', '光华走1');
INSERT INTO `broker` VALUES ('3', '身份证', '123462', 'Holer2', '02222122', '光华走2');
INSERT INTO `broker` VALUES ('4', '身份证', '123463', 'Holer3', '02222123', '光华走3');
INSERT INTO `broker` VALUES ('5', '身份证', '123464', 'Holer4', '02222124', '光华走4');
INSERT INTO `broker` VALUES ('6', '身份证', '123465', 'Holer5', '02222125', '光华走5');
INSERT INTO `broker` VALUES ('7', '身份证', '123466', 'Holer6', '02222126', '光华走6');
INSERT INTO `broker` VALUES ('8', '身份证', '123467', 'Holer7', '02222127', '光华走7');
INSERT INTO `broker` VALUES ('9', '身份证', '123468', 'Holer8', '02222128', '光华走8');
INSERT INTO `broker` VALUES ('10', '身份证', '123469', 'Holer9', '02222129', '光华走9');

-- ----------------------------
-- Table structure for brokerhouse
-- ----------------------------
DROP TABLE IF EXISTS `brokerhouse`;
CREATE TABLE `brokerhouse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `broker_id` bigint(20) DEFAULT NULL,
  `house_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf8ft7vhydanc3w9va8cs27u1y` (`broker_id`),
  KEY `FKid2691k9kmlv4j14wnpo4hiua` (`house_id`),
  CONSTRAINT `FKf8ft7vhydanc3w9va8cs27u1y` FOREIGN KEY (`broker_id`) REFERENCES `broker` (`id`),
  CONSTRAINT `FKid2691k9kmlv4j14wnpo4hiua` FOREIGN KEY (`house_id`) REFERENCES `houseinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brokerhouse
-- ----------------------------
INSERT INTO `brokerhouse` VALUES ('1', '1', '4');

-- ----------------------------
-- Table structure for houseinfo
-- ----------------------------
DROP TABLE IF EXISTS `houseinfo`;
CREATE TABLE `houseinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of houseinfo
-- ----------------------------
INSERT INTO `houseinfo` VALUES ('1', '画好0', '普通0', '三房0', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州0', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('2', '画好1', '普通1', '三房1', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州1', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('3', '画好2', '普通2', '三房2', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州2', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('4', '画好3', '普通3', '三房3', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州3', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('6', '画好5', '普通5', '三房5', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州5', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('7', '画好6', '普通6', '三房6', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州6', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('8', '画好7', '普通7', '三房7', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州7', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('9', '画好8', '普通8', '三房8', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州8', '5/6', '豪华', '电视,电脑', '海景房', 'Y');
INSERT INTO `houseinfo` VALUES ('10', '画好9', '普通9', '三房9', '130.5', '5000.5', '合租', '押一付三', '东南向', '广州9', '5/6', '豪华', '电视,电脑', '海景房', 'Y');

-- ----------------------------
-- Table structure for letinfo
-- ----------------------------
DROP TABLE IF EXISTS `letinfo`;
CREATE TABLE `letinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `letName` varchar(15) NOT NULL,
  `house_id_let` bigint(20) DEFAULT NULL,
  `renter_id` bigint(20) DEFAULT NULL,
  `broker_id_let` bigint(20) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of letinfo
-- ----------------------------
INSERT INTO `letinfo` VALUES ('1', '2', '4', '6', '1', '2017-08-17', '3', '2017-08-27');

-- ----------------------------
-- Table structure for renter
-- ----------------------------
DROP TABLE IF EXISTS `renter`;
CREATE TABLE `renter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `credentials_type` varchar(10) NOT NULL,
  `credentials_id` varchar(20) NOT NULL,
  `personName` varchar(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renter
-- ----------------------------
INSERT INTO `renter` VALUES ('1', '身份证', '123460', 'Holer0', '02222');
INSERT INTO `renter` VALUES ('2', '身份证', '123461', 'Holer1', '02222121');
INSERT INTO `renter` VALUES ('3', '身份证', '123462', 'Holer2', '02222122');
INSERT INTO `renter` VALUES ('4', '身份证', '123463', 'Holer3', '02222123');
INSERT INTO `renter` VALUES ('5', '身份证', '123464', 'Holer4', '02222124');
INSERT INTO `renter` VALUES ('6', '身份证', '123465', 'Holer5', '02222125');
INSERT INTO `renter` VALUES ('7', '身份证', '123466', 'Holer6', '02222126');
INSERT INTO `renter` VALUES ('8', '身份证', '123467', 'Holer7', '02222127');
INSERT INTO `renter` VALUES ('9', '身份证', '123468', 'Holer8', '02222128');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Holer', '123456');
INSERT INTO `user` VALUES ('2', '123', '456');
INSERT INTO `user` VALUES ('3', '555', '546');

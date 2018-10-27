/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.7
 Source Server Type    : MySQL
 Source Server Version : 50552
 Source Host           : 192.168.1.7
 Source Database       : course

 Target Server Type    : MySQL
 Target Server Version : 50552
 File Encoding         : utf-8

 Date: 04/19/2018 22:53:03 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `addUserCase`
-- ----------------------------
DROP TABLE IF EXISTS `addUserCase`;
CREATE TABLE `addUserCase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `addUserCase`
-- ----------------------------
BEGIN;
INSERT INTO `addUserCase` VALUES ('1', 'zhao9', 'zhaozhao', '0', '35', '1', '0', 'true');
COMMIT;

-- ----------------------------
--  Table structure for `getUserInfoCase`
-- ----------------------------
DROP TABLE IF EXISTS `getUserInfoCase`;
CREATE TABLE `getUserInfoCase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(11) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `getUserInfoCase`
-- ----------------------------
BEGIN;
INSERT INTO `getUserInfoCase` VALUES ('1', '1', 'getUserInfo');
COMMIT;

-- ----------------------------
--  Table structure for `getUserListCase`
-- ----------------------------
DROP TABLE IF EXISTS `getUserListCase`;
CREATE TABLE `getUserListCase` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `expected` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `getUserListCase`
-- ----------------------------
BEGIN;
INSERT INTO `getUserListCase` VALUES ('1', null, null, '0', 'getUserList');
COMMIT;

-- ----------------------------
--  Table structure for `loginCase`
-- ----------------------------
DROP TABLE IF EXISTS `loginCase`;
CREATE TABLE `loginCase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `loginCase`
-- ----------------------------
BEGIN;
INSERT INTO `loginCase` VALUES ('1', 'zhangsan', '123456', 'true'), ('2', 'zhangsanerror', '123', 'false');
COMMIT;

-- ----------------------------
--  Table structure for `updateUserInfoCase`
-- ----------------------------
DROP TABLE IF EXISTS `updateUserInfoCase`;
CREATE TABLE `updateUserInfoCase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(11) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `updateUserInfoCase`
-- ----------------------------
BEGIN;
INSERT INTO `updateUserInfoCase` VALUES ('1', '2', 'hahahaha', null, null, null, null, 'getUpdateUserInfo'), ('2', '8', null, null, null, null, '1', 'getUpdateUserInfo');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'zhangsan', '123456', '20', '0', '0', '0'), ('2', 'hahahaha', '123456', '25', '1', '1', '0'), ('3', 'wang5', '123456', '30', '0', '1', '0'), ('4', 'wang56', '123456', '40', '1', '1', '0'), ('5', 'wang577', '123', '20', '0', '0', '0'), ('6', 'zhaozhao', 'wqer', '30', '1', '1', '0'), ('7', 'qiqiqi', 'sdffa', '50', '1', '0', '0'), ('8', 'ewrwer', 'qazedx', '40', '1', '0', '1'), ('69', 'zhao9', 'zhaozhao', '35', '0', '1', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

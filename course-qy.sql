/*
Navicat MySQL Data Transfer

Source Server         : localhost-密码admin
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-19 12:32:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `addusercase`
-- ----------------------------
DROP TABLE IF EXISTS `addusercase`;
CREATE TABLE `addusercase` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addusercase
-- ----------------------------
INSERT INTO `addusercase` VALUES ('1', 'zhao9', 'zhaozhao', '0', '35', '1', '0', 'true');

-- ----------------------------
-- Table structure for `getuserinfocase`
-- ----------------------------
DROP TABLE IF EXISTS `getuserinfocase`;
CREATE TABLE `getuserinfocase` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getuserinfocase
-- ----------------------------
INSERT INTO `getuserinfocase` VALUES ('1', '1', 'getUserInfo');

-- ----------------------------
-- Table structure for `getuserlistcase`
-- ----------------------------
DROP TABLE IF EXISTS `getuserlistcase`;
CREATE TABLE `getuserlistcase` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `age` varchar(11) DEFAULT NULL,
  `sex` varchar(11) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getuserlistcase
-- ----------------------------
INSERT INTO `getuserlistcase` VALUES ('1', null, null, '0', 'getUserList');

-- ----------------------------
-- Table structure for `logincase`
-- ----------------------------
DROP TABLE IF EXISTS `logincase`;
CREATE TABLE `logincase` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logincase
-- ----------------------------
INSERT INTO `logincase` VALUES ('1', 'zhangsan', '123456', 'true');
INSERT INTO `logincase` VALUES ('2', 'zhangsanerror', '123', 'false');

-- ----------------------------
-- Table structure for `updateuserinfocase`
-- ----------------------------
DROP TABLE IF EXISTS `updateuserinfocase`;
CREATE TABLE `updateuserinfocase` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of updateuserinfocase
-- ----------------------------
INSERT INTO `updateuserinfocase` VALUES ('1', '2', 'hahaha', null, null, null, null, 'getUpdateUserInfo');
INSERT INTO `updateuserinfocase` VALUES ('2', '8', null, null, null, null, '1', 'getUpdateUserInfo');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123456', '20', '0', '0', '0');
INSERT INTO `user` VALUES ('2', 'lisi', '123456', '25', '1', '1', '0');
INSERT INTO `user` VALUES ('3', 'wangwu', '123456', '30', '0', '1', '0');
INSERT INTO `user` VALUES ('4', 'zhaoliu', '123456', '40', '1', '1', '0');
INSERT INTO `user` VALUES ('5', 'zhang1', '123', '20', '0', '0', '0');
INSERT INTO `user` VALUES ('6', 'zhao2', 'wqer', '30', '1', '1', '0');
INSERT INTO `user` VALUES ('7', 'li3', 'sdffa', '50', '1', '0', '0');
INSERT INTO `user` VALUES ('8', 'wu5', 'qazedx', '40', '1', '0', '0');
INSERT INTO `user` VALUES ('11', 'zhao9', 'zhaozhao', '35', '0', '1', '0');

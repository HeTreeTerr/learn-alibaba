/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : alibaba-cloud-pay

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-01-18 00:28:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

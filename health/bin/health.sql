/*
 Navicat MySQL Data Transfer

 Source Server         : localMysql
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : health

 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 11/15/2018 15:14:18 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `session`
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `doctor_id` bigint(20) NOT NULL,
  `doctor_name` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `session_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `session`
-- ----------------------------
BEGIN;
INSERT INTO `session` VALUES ('1', '2018-11-14 15:35:53', '6', 'Doc_wang'), ('2', '2018-11-17 15:36:04', '6', 'Doc_wang');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `token` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1:Patients 2:Doctors 3:Admin\n',
  `address` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phone` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'test', 'test', '8961289648921469821', '1', '', '2018-11-14 20:06:14', '2018-11-14 20:06:14', ''), ('2', 'admin', 'admin', '', '1', '', '2018-11-14 20:07:18', '2018-11-14 20:07:18', ''), ('3', '', 'test1', '', '1', '', '2018-11-14 22:48:34', '2018-11-14 22:48:34', ''), ('4', 'test123', 'test123', '', '1', '', '2018-11-14 22:50:01', '2018-11-14 22:50:01', ''), ('5', 'jack', '123456', '', '1', 'kill road 1', '2018-11-14 23:13:15', '2018-11-14 23:13:15', '19789414'), ('6', 'Doc_wang', '123456', '', '2', '', '2018-11-14 23:35:38', '2018-11-14 23:35:38', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

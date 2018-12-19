/*
 Navicat MySQL Data Transfer

 Source Server         : localMysql
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : health

 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 11/24/2018 00:12:11 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `appointment`
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `patient_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0new,1schedule,3pay',
  `bill_id` bigint(20) DEFAULT NULL,
  `prescription_id` bigint(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `doctor_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `appointment`
-- ----------------------------
BEGIN;
INSERT INTO `appointment` VALUES ('2', '1', null, '2', '2018-11-23 17:11:08', 'Doc_wang', '6', '2'), (null, '0', null, null, '2018-11-21 22:20:15', 'Doc_wang', '6', '3'), (null, '0', null, null, '2018-11-24 00:00:00', 'Doc_wang', '6', '4'), (null, '0', null, null, '2018-11-21 22:21:55', 'Doc_wang', '6', '5'), ('1', '1', null, null, '2018-11-21 22:25:13', 'Doc_wang', '6', '6');
COMMIT;

-- ----------------------------
--  Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appointment_id` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bill_id_uindex` (`id`),
  UNIQUE KEY `bill_appointment_id_uindex` (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `bill`
-- ----------------------------
BEGIN;
INSERT INTO `bill` VALUES ('1', '2', '150', '1', '112.5'), ('2', '6', '333', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `prescription`
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `diagnosis` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `medicine` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `appointment_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `prescription`
-- ----------------------------
BEGIN;
INSERT INTO `prescription` VALUES ('leg broken', 'm1', '2', '2');
COMMIT;

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
  `name` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `token` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1:Patients 2:Doctors 3:Admin\n',
  `address` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phone` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `title` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('l', '123456', '', '1', '', '2018-11-23 16:40:05', '2018-11-23 16:40:05', '1233221', '', '1'), ('test', 'test', '05a671c66aefea124cc08b76ea6d30bb', '1', '', '2018-11-14 23:35:38', '2018-11-14 23:35:38', '', '', '2'), ('z', '123456', '', '1', '', '2018-11-23 16:42:09', '2018-11-23 16:42:09', '21414', '', '3'), ('admin', 'admin', 'f6fdffe48c908deb0f4c3bd36c032e72', '3', '', '2018-11-14 20:07:18', '2018-11-14 20:07:18', '', null, '4'), ('jack', '123456', '', '1', 'kill road 1', '2018-11-14 23:13:15', '2018-11-14 23:13:15', '19789414', '', '5'), ('Doc_wang', '123456', '52d49da48dbbbc034d1b1969c337dbd9', '2', 'Road 123', '2018-11-14 20:06:14', '2018-11-14 20:06:14', '19789414', null, '6'), ('test123', 'test123', '', '1', '', '2018-11-14 22:50:01', '2018-11-14 22:50:01', '', null, '7'), ('test222', 'test222', '', '1', 'Road qw', '2018-11-15 21:02:53', '2018-11-15 21:02:53', '211454667', null, '8'), ('Doc_wang1', '123456', '', '2', '', '2018-11-23 16:44:21', '2018-11-23 16:44:21', '12352355523', 'ww', '9'), ('Doc_122', '123456', '', '2', '', '2018-11-23 16:45:06', '2018-11-23 16:45:06', '122', '122', '10');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : oa

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 26/05/2019 16:36:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '技术部', '2019-05-25 11:13:20', '2019-05-25 11:13:20', '部门描述', '计国清');
INSERT INTO `department` VALUES (2, '董事会', '2019-05-25 11:14:05', '2019-05-25 11:14:05', '我是股东', '靳雯');
INSERT INTO `department` VALUES (3, '中南海', '2019-05-25 11:15:18', '2019-05-25 11:15:18', '我最乖', '计然');
INSERT INTO `department` VALUES (4, '做饭吃饭', '2019-05-25 22:19:15', '2019-05-25 22:19:42', '好', '吕明珠-靳品贵');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `english_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `job_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `location` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `onboard_at` datetime DEFAULT NULL,
  `leaved_at` datetime DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '计然', 'Ryan', '2019-05-25 20:09:07', '2019-05-25 20:09:07', '001', 3, '总经理', '男', 'sh', '93326792@qq.com', '134', '你好', '2019-05-22 18:14:32', '2019-05-24 18:14:47', 'T1', 'ON_DUTY');
INSERT INTO `employee` VALUES (2, '技术部', '', '2019-05-25 21:45:43', '2019-05-26 16:29:05', '', NULL, '', '', '', '', '', '', '1970-01-01 00:00:00', '1970-01-01 00:00:00', '', 'INTER');
INSERT INTO `employee` VALUES (3, '技术部', '', '2019-05-25 21:45:48', '2019-05-26 16:30:11', '', NULL, '', '', '', '', '', '', '1970-01-01 00:00:00', '1970-01-01 00:00:00', '', 'TRIAL');
INSERT INTO `employee` VALUES (4, '技术部', '', '2019-05-25 21:45:54', '2019-05-26 16:30:22', '', NULL, '', '', '', '', '', '', '1970-01-01 00:00:00', '1970-01-01 00:00:00', '', 'ON_DUTY');
INSERT INTO `employee` VALUES (5, '技术部', '', '2019-05-25 21:45:58', '2019-05-26 16:10:48', '', NULL, '', '', '', '', '', '', '1970-01-01 00:00:00', '1970-01-01 00:00:00', '', 'INTER');
INSERT INTO `employee` VALUES (6, '技术部', '', '2019-05-25 21:46:02', '2019-05-25 21:46:02', '', NULL, '', '', '', '', '', '', NULL, NULL, '', NULL);
INSERT INTO `employee` VALUES (7, '技术部', '', '2019-05-25 21:46:07', '2019-05-25 21:46:07', '', NULL, '', '', '', '', '', '', NULL, NULL, '', NULL);
INSERT INTO `employee` VALUES (8, '技术部', '', '2019-05-25 21:46:11', '2019-05-26 16:11:06', '', NULL, '', '', '', '', '', '', '1970-01-01 00:00:00', '1970-01-01 00:00:00', '', 'INTER');
INSERT INTO `employee` VALUES (9, '计然', 'Ryan', '2019-05-25 21:46:23', '2019-05-26 16:32:42', '001', 2, '总经理', '男', 'sh', '93326792@qq.com', '1592188', '', '2019-05-26 16:32:25', NULL, 'T1', 'ON_DUTY');
INSERT INTO `employee` VALUES (10, '技术部', '', '2019-05-25 21:46:28', '2019-05-26 16:10:05', '', NULL, '', '', '', '', '', '', '1970-01-01 00:00:00', '1970-01-01 00:00:00', '', 'INTER');
INSERT INTO `employee` VALUES (11, '靳品贵', 'agui', '2019-05-25 22:07:41', '2019-05-26 16:06:47', '003', 4, '工程师', '男', 'km', '93326792@qq.com', '135', '', '2019-05-22 16:06:16', '2019-05-28 16:06:43', 'T1', 'INTER');
INSERT INTO `employee` VALUES (12, '计国清', 'jim', '2019-05-25 22:24:51', '2019-05-26 16:05:41', '002', 2, '工程师', '男', 'sh', '93326792@qq.com', '134', '', '2019-05-28 00:00:00', '2019-05-30 00:00:00', 'T1', 'TRIAL');
INSERT INTO `employee` VALUES (13, '靳雯', 'stella', '2019-05-26 16:08:04', '2019-05-26 16:08:04', '002', 4, '工程师', '女', 'sh', '35040442@qq.com', '1592188', '备注', '2019-05-28 16:07:34', NULL, 'T1', 'TRIAL');
INSERT INTO `employee` VALUES (14, '吕明珠', 'mingzhu', '2019-05-26 16:08:41', '2019-05-26 16:08:41', '004', 4, '工程师', '女', '', '', '', '', '2019-05-28 16:08:30', NULL, 'T1', 'INTER');
INSERT INTO `employee` VALUES (15, '计文龙', 'long', '2019-05-26 16:09:17', '2019-05-26 16:09:17', '005', 4, '工程师', '男', '', '35040442@qq.com', '130', '', '2019-05-28 16:09:01', NULL, 'T1', 'INTER');
INSERT INTO `employee` VALUES (16, '赵爱玉', 'yu', '2019-05-26 16:09:50', '2019-05-26 16:09:50', '006', 4, '工程师', '女', '', '35040442@qq.com', '176', '', '2019-05-26 16:09:39', NULL, 'T1', 'TRIAL');

SET FOREIGN_KEY_CHECKS = 1;

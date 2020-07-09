/*
 Navicat Premium Data Transfer

 Source Server         : Root
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : ldm

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/12/2019 18:27:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`adminNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Issue` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cost` double NOT NULL,
  `Descy` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `Issue`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `borDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `retDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `retSta` tinyint(1) NOT NULL,
  `stuNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `devNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for devinfo
-- ----------------------------
DROP TABLE IF EXISTS `devinfo`;
CREATE TABLE `devinfo`  (
  `devNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FeaCode` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isAvai` tinyint(1) NOT NULL,
  `isBorr` tinyint(1) NOT NULL,
  `isRepair` tinyint(1) NOT NULL,
  `isScrap` tinyint(1) NOT NULL,
  PRIMARY KEY (`devNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inventery
-- ----------------------------
DROP TABLE IF EXISTS `inventery`;
CREATE TABLE `inventery`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FeaCode` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Num` int(11) NOT NULL,
  `purDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purWay` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `devName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for preorder
-- ----------------------------
DROP TABLE IF EXISTS `preorder`;
CREATE TABLE `preorder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Num` int(11) NOT NULL,
  `ordDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `devName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purinfo
-- ----------------------------
DROP TABLE IF EXISTS `purinfo`;
CREATE TABLE `purinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `applyNum` int(11) NOT NULL,
  `price` double NOT NULL,
  `applyDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Opinion` tinyint(1) NOT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `devName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sendDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `breakdown` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Fix` tinyint(1) NULL DEFAULT NULL,
  `Cost` double NOT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `devNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for scrap
-- ----------------------------
DROP TABLE IF EXISTS `scrap`;
CREATE TABLE `scrap`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `devName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scrapDate` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scrapReason` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `opinion` tinyint(1) NULL DEFAULT NULL,
  `adminNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `devNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuNo` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` int(11) NOT NULL,
  PRIMARY KEY (`stuNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

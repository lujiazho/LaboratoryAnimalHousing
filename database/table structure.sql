/*
 Navicat Premium Data Transfer

 Source Server         : 软工数据库
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 120.24.43.51:3306
 Source Schema         : sedb

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 17/07/2020 18:54:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 2020rg_group3_t_employeebaseinfo
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group3_t_employeebaseinfo`;
CREATE TABLE `2020rg_group3_t_employeebaseinfo`  (
  `Employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `EmployeeNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工编号',
  `EmployeeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `EmployeeSex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男' COMMENT '员工性别',
  `EmployeeDepartment` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工部门',
  `EmployeeRole` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工角色',
  `EmployeeAge` int(3) NOT NULL COMMENT '员工年龄',
  `EmployeeEducation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工学历',
  `EmployeeCertificatesType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '身份证' COMMENT '员工证件类型',
  `EmployeeCertificatesNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工证件号码',
  `EmployeeState` enum('在职','离职','退休') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '在职' COMMENT '员工状态',
  `EmployeePhoneNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工电话号',
  `EmployeePassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '员工密码',
  PRIMARY KEY (`Employeeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_application
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_application`;
CREATE TABLE `2020rg_group13_application`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ename_id` int(11) NOT NULL COMMENT '设备id',
  `sname_id` int(11) NOT NULL COMMENT '型号id',
  `demandnum` int(11) NOT NULL COMMENT '需求数量',
  `employee_id` int(11) NOT NULL COMMENT '员工表中id',
  `applicationdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `receivednum` int(11) NOT NULL DEFAULT 0 COMMENT '接受数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `LAH_L_EQUIPNAME1`(`ename_id`) USING BTREE,
  INDEX `LAH_L_EQUIPSPEC1`(`sname_id`) USING BTREE,
  INDEX `LAH_L_EMPLOYEE`(`employee_id`) USING BTREE,
  CONSTRAINT `LAH_L_EMPLOYEE` FOREIGN KEY (`employee_id`) REFERENCES `2020rg_group13_usertable` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `LAH_L_EQUIPNAME1` FOREIGN KEY (`ename_id`) REFERENCES `2020rg_group13_equipname` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `LAH_L_EQUIPSPEC1` FOREIGN KEY (`sname_id`) REFERENCES `2020rg_group13_equipspec` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_equipname
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_equipname`;
CREATE TABLE `2020rg_group13_equipname`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_equipspec
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_equipspec`;
CREATE TABLE `2020rg_group13_equipspec`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备型号id',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备型号',
  `eid` int(11) NOT NULL COMMENT '依赖的设备id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `LAH_L_EID`(`eid`) USING BTREE,
  CONSTRAINT `LAH_L_EID` FOREIGN KEY (`eid`) REFERENCES `2020rg_group13_equipname` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_equiptable
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_equiptable`;
CREATE TABLE `2020rg_group13_equiptable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipmentname_id` int(11) NOT NULL COMMENT '设备id',
  `specificationmodel_id` int(11) NOT NULL COMMENT '型号id',
  `loggingdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `equipmentnumber` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `usage` int(11) NOT NULL DEFAULT 1 COMMENT '1表示使用中，2表示已损坏',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `LAH_L_EQUIPNAME`(`equipmentname_id`) USING BTREE,
  INDEX `LAH_L_EQUIPSPEC`(`specificationmodel_id`) USING BTREE,
  CONSTRAINT `LAH_L_EQUIPNAME` FOREIGN KEY (`equipmentname_id`) REFERENCES `2020rg_group13_equipname` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `LAH_L_EQUIPSPEC` FOREIGN KEY (`specificationmodel_id`) REFERENCES `2020rg_group13_equipspec` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_maintenance
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_maintenance`;
CREATE TABLE `2020rg_group13_maintenance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ename_id` int(11) NOT NULL COMMENT '设备id',
  `sname_id` int(11) NOT NULL COMMENT '型号id',
  `maintainer_id` int(11) NOT NULL COMMENT '用户管理的员工表中id',
  `enumber` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号',
  `maintenanceresult` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '检修结果',
  `maintenancedate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '检修日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `LAH_L_EQUIPNAME2`(`ename_id`) USING BTREE,
  INDEX `LAH_L_EQUIPSPEC2`(`sname_id`) USING BTREE,
  INDEX `LAH_L_MAINTAINER`(`maintainer_id`) USING BTREE,
  CONSTRAINT `LAH_L_EQUIPNAME2` FOREIGN KEY (`ename_id`) REFERENCES `2020rg_group13_equipname` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `LAH_L_EQUIPSPEC2` FOREIGN KEY (`sname_id`) REFERENCES `2020rg_group13_equipspec` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `LAH_L_MAINTAINER` FOREIGN KEY (`maintainer_id`) REFERENCES `2020rg_group3_t_employeebaseinfo` (`Employeeid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_usertable
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_usertable`;
CREATE TABLE `2020rg_group13_usertable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '202000001' COMMENT '员工编号',
  `loginname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 2020rg_group13_wastetable
-- ----------------------------
DROP TABLE IF EXISTS `2020rg_group13_wastetable`;
CREATE TABLE `2020rg_group13_wastetable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loggingdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `wasteweight` double NOT NULL,
  `recycable` int(11) NOT NULL COMMENT '1表示可回收,2不可',
  `wastetype` int(11) NOT NULL COMMENT ' 1表示生物,2普通',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

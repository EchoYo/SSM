/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : JTOA

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-06-21 08:54:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountId` varchar(30) NOT NULL,
  `passWord` varchar(30) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `roleId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', '', '陈苏俊', '');
INSERT INTO `account` VALUES ('2', 'wenkong', '', '王婉', 'R001');
INSERT INTO `account` VALUES ('3', 'cangku', '', '杨海斌', 'R002');

-- ----------------------------
-- Table structure for drawing
-- ----------------------------
DROP TABLE IF EXISTS `drawing`;
CREATE TABLE `drawing` (
  `id` bigint(20) NOT NULL,
  `date` char(10) NOT NULL,
  `sampleDrawingEdition` varchar(20) DEFAULT NULL,
  `customerName` varchar(40) DEFAULT NULL,
  `customerDrawingName` varchar(40) DEFAULT NULL,
  `customerDrawingNumber` varchar(40) DEFAULT NULL,
  `customerDrawingEdition` varchar(40) DEFAULT NULL,
  `moldDrawingEdition` varchar(40) DEFAULT NULL,
  `moldDrawingDate` char(10) DEFAULT NULL,
  `formalDrawingEdition` varchar(40) DEFAULT NULL,
  `formalDrawingDate` char(10) DEFAULT NULL,
  `craftNumber` varchar(40) DEFAULT NULL,
  `craftEdition` varchar(40) DEFAULT NULL,
  `craftDate` char(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drawing
-- ----------------------------

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `privilegeId` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parentId` varchar(20) DEFAULT NULL,
  `spanClass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES ('1', 'P100', '文控中心', '/drawing/dwgUI.do', null, 'icon icon-flatscreen');
INSERT INTO `privilege` VALUES ('2', 'P101', '图纸信息', 'tables', 'P100', 'tables');
INSERT INTO `privilege` VALUES ('3', 'P102', '图纸管理', 'formsub', 'P100', 'editor');
INSERT INTO `privilege` VALUES ('4', 'P103', '制样用图信息', '/drawing/zylist.do', 'P101', null);
INSERT INTO `privilege` VALUES ('5', 'P104', '样品模具信息', '/drawing/mjlist.do', 'P101', null);
INSERT INTO `privilege` VALUES ('6', 'P105', '量产图纸信息', '/drawing/sclist.do', 'P101', null);
INSERT INTO `privilege` VALUES ('7', 'P106', '图纸录入', '/drawing/addUI.do', 'P102', null);
INSERT INTO `privilege` VALUES ('8', 'P107', '图纸查询', '/drawing/searchUI.do', 'P102', null);
INSERT INTO `privilege` VALUES ('9', 'P108', '导入数据', '/drawing/importUI.do', 'P102', null);
INSERT INTO `privilege` VALUES ('10', 'P109', '标签管理', '/labelUI.do', null, 'icon icon-pencil');
INSERT INTO `privilege` VALUES ('11', 'P110', '人事考勤', '/drawing/dwgUI.do', null, 'icon icon-message');
INSERT INTO `privilege` VALUES ('12', 'P111', '唯信标签', 'tables', 'P109', 'tables');
INSERT INTO `privilege` VALUES ('13', 'P112', '紫翔标签', 'formsub', 'P109', 'editor');
INSERT INTO `privilege` VALUES ('14', 'P113', '标签信息', '/wx/list.do', 'P111', null);
INSERT INTO `privilege` VALUES ('15', 'P114', '标签录入', '/wx/addUI.do', 'P111', null);
INSERT INTO `privilege` VALUES ('16', 'P115', '标签信息', '/zx/list.do', 'P112', null);
INSERT INTO `privilege` VALUES ('17', 'P116', '标签录入', '/zx/addUI.do', 'P112', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` varchar(20) NOT NULL,
  `privilegeId` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'R001', 'P100', '文控');
INSERT INTO `role` VALUES ('2', 'R001', 'P101', '文控');
INSERT INTO `role` VALUES ('3', 'R001', 'P102', '文控');
INSERT INTO `role` VALUES ('4', 'R001', 'P103', '文控');
INSERT INTO `role` VALUES ('5', 'R001', 'P104', '文控');
INSERT INTO `role` VALUES ('6', 'R001', 'P105', '文控');
INSERT INTO `role` VALUES ('8', 'R001', 'P107', '文控');
INSERT INTO `role` VALUES ('9', 'R001', 'P106', '文控');
INSERT INTO `role` VALUES ('10', 'R001', 'P110', '文控');
INSERT INTO `role` VALUES ('14', 'R002', 'P109', '标签');
INSERT INTO `role` VALUES ('15', 'R002', 'P111', '标签');
INSERT INTO `role` VALUES ('16', 'R002', 'P112', '标签');
INSERT INTO `role` VALUES ('17', 'R002', 'P113', '标签');
INSERT INTO `role` VALUES ('18', 'R002', 'P114', '标签');
INSERT INTO `role` VALUES ('19', 'R002', 'P115', '标签');
INSERT INTO `role` VALUES ('20', 'R002', 'P116', '标签');

/*
 Navicat MySQL Data Transfer

 Source Server         : 测试环境
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 123.206.18.37
 Source Database       : api_center

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : utf-8

 Date: 01/23/2018 16:48:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `api_center_api`
-- ----------------------------
DROP TABLE IF EXISTS `api_center_api`;
CREATE TABLE `api_center_api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `api_name` varchar(20) NOT NULL COMMENT 'api名称',
  `api_agreement` varchar(20) NOT NULL COMMENT 'api协议',
  `api_mode` varchar(20) NOT NULL COMMENT '请求方式',
  `api_domain` varchar(50) NOT NULL COMMENT '域名',
  `api_address` varchar(100) NOT NULL COMMENT 'api地址',
  `api_describe` varchar(200) NOT NULL COMMENT '描述',
  `founder_user_id` int(11) NOT NULL COMMENT 'api创建人',
  `create_time` bigint(30) NOT NULL COMMENT '创建时间',
  `api_group_id` int(11) NOT NULL COMMENT 'api所属分组',
  `api_result_data` text,
  PRIMARY KEY (`id`),
  KEY `api_group_id` (`api_group_id`),
  KEY `founder_user_id` (`founder_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `api_center_group`
-- ----------------------------
DROP TABLE IF EXISTS `api_center_group`;
CREATE TABLE `api_center_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(30) NOT NULL COMMENT '分组名称',
  `create_time` bigint(30) NOT NULL COMMENT '创建时间',
  `founder_user_id` int(11) NOT NULL COMMENT '分组创建人',
  PRIMARY KEY (`id`),
  KEY `founder_user_id` (`founder_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `api_center_param`
-- ----------------------------
DROP TABLE IF EXISTS `api_center_param`;
CREATE TABLE `api_center_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数id',
  `api_id` int(11) NOT NULL COMMENT '所属api的id',
  `param_name` varchar(20) NOT NULL COMMENT '参数名称',
  `param_describe` varchar(20) NOT NULL COMMENT '参数描述',
  `param_type` varchar(20) NOT NULL COMMENT '参数类型',
  `test_value` varchar(100) DEFAULT NULL COMMENT '测试参数值',
  `isoptional` int(2) NOT NULL DEFAULT '0' COMMENT '是否可选  0 可选 1不可选',
  PRIMARY KEY (`id`),
  KEY `api_id` (`api_id`)
) ENGINE=MyISAM AUTO_INCREMENT=330 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `api_center_return`
-- ----------------------------
DROP TABLE IF EXISTS `api_center_return`;
CREATE TABLE `api_center_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `return_name` varchar(20) NOT NULL COMMENT '返回名',
  `return_describe` varchar(100) NOT NULL COMMENT '返回描述',
  `return_type` varchar(20) NOT NULL COMMENT '返回类型',
  `api_id` int(11) NOT NULL COMMENT '所属apiid',
  PRIMARY KEY (`id`),
  KEY `api_id` (`api_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `api_center_user`
-- ----------------------------
DROP TABLE IF EXISTS `api_center_user`;
CREATE TABLE `api_center_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `user_role` varchar(10) DEFAULT NULL COMMENT '角色',
  `user_number` varchar(10) DEFAULT NULL COMMENT '账号',
  `user_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `create_time` bigint(30) DEFAULT '0' COMMENT '账户生成时间',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

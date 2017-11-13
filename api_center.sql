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

 Date: 11/13/2017 19:49:27 PM
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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `api_center_api`
-- ----------------------------
BEGIN;
INSERT INTO `api_center_api` VALUES ('1', '我的业绩', 'http', 'post', 'test.allxiu.com', '/sale/list', '我的业绩调用,该接口已做缓存处理', '1', '1111111', '1'), ('9', '5', 'HTTP', 'GET', 'http://test.allxiu.com', '5', '5', '1', '1506423140135', '1'), ('8', '4', 'HTTP', 'GET', 'http://test.allxiu.com', '4', '4', '1', '1506423082758', '1'), ('7', '2', 'HTTP', 'GET', 'http://test.allxiu.com', '2', '2', '1', '1506422864124', '1'), ('6', '1', 'HTTP', 'GET', 'http://test.allxiu.com', '1', '1', '1', '1506422663987', '1'), ('10', '111', 'HTTP', 'GET', 'http://test.allxiu.com', '1', '1', '1', '1506423325202', '1'), ('11', '211241241', 'HTTP', 'GET', 'http://test.allxiu.com', '124124', '1421241', '1', '1506423456427', '1'), ('12', '211241241', 'HTTP', 'GET', 'http://test.allxiu.com', '124124', '1421241', '1', '1506423555086', '1'), ('13', '123', 'HTTP', 'GET', 'http://test.allxiu.com', '123', '123', '1', '1506424857852', '1'), ('14', '1', 'HTTP', 'GET', 'http://test.allxiu.com', '1', '1', '1', '1506424928576', '1'), ('15', '123', 'HTTP', 'GET', 'http://test.allxiu.com', '123', '123', '1', '1506425277426', '1');
COMMIT;

-- ----------------------------
--  Table structure for `api_center_group`
-- ----------------------------
DROP TABLE IF EXISTS `api_center_group`;
CREATE TABLE `api_center_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(30) NOT NULL COMMENT '分组名称',
  `create_time` bigint(30) NOT NULL COMMENT '创建时间',
  `founder_user_id` int(11) NOT NULL COMMENT '分组创建人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `api_center_group`
-- ----------------------------
BEGIN;
INSERT INTO `api_center_group` VALUES ('1', '销售模块', '0', '1'), ('2', '订单模块', '0', '1'), ('3', '摄影师模块', '0', '1'), ('4', 'public', '0', '1'), ('5', 'h5', '0', '1');
COMMIT;

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `api_center_param`
-- ----------------------------
BEGIN;
INSERT INTO `api_center_param` VALUES ('1', '1', 'page', '页码', 'int', '1', '1'), ('2', '1', 'pageSize', '每页多少条', 'int', '10', '1');
COMMIT;

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `api_center_return`
-- ----------------------------
BEGIN;
INSERT INTO `api_center_return` VALUES ('1', 'code', '约定code', 'String', '1'), ('2', 'data', '数据', 'String', '1');
COMMIT;

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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `api_center_user`
-- ----------------------------
BEGIN;
INSERT INTO `api_center_user` VALUES ('1', '001', '牛逼者', '001', '1', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

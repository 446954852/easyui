/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : easyui

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2016-10-09 22:29:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `ID` bigint(36) NOT NULL AUTO_INCREMENT,
  `PID` bigint(36) DEFAULT NULL,
  `TEXT` varchar(100) DEFAULT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `ICONCLS` varchar(100) DEFAULT NULL,
  `SEQ` decimal(22,0) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `menuFK` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', null, '首页', 'url1', null, '0');
INSERT INTO `menu` VALUES ('2', '1', '系统管理', 'url2', null, '0');
INSERT INTO `menu` VALUES ('3', '2', '菜单管理', 'url3', null, '0');
INSERT INTO `menu` VALUES ('4', '2', '角色管理', 'url4', null, '0');
INSERT INTO `menu` VALUES ('5', '2', '权限管理', 'url5', null, '0');
INSERT INTO `menu` VALUES ('6', '2', '用户管理', 'url6', null, '0');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `parentids` varchar(128) DEFAULT NULL COMMENT '父结点id列表串',
  `sortstring` varchar(128) DEFAULT NULL COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '权限', '', '', null, '0', '0/', '0', '1');
INSERT INTO `sys_permission` VALUES ('11', '商品管理', 'menu', '/item/manager', 'item:manager', '1', '0/1/', '1.', '1');
INSERT INTO `sys_permission` VALUES ('12', '商品新增', 'permission', '/item/add', 'item:create', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('13', '商品修改', 'permission', '/item/edit', 'item:update', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('14', '商品删除', 'permission', '/item/delete', 'item:delete', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('15', '商品查询', 'permission', '/item/query', 'item:query', '11', '0/1/11/', null, '1');
INSERT INTO `sys_permission` VALUES ('21', '用户管理', 'menu', '/user/manager', 'user:manager', '1', '0/1/', '2.', '1');
INSERT INTO `sys_permission` VALUES ('22', '用户新增', 'permission', '/user/add', 'user:create', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('23', '用户修改', 'permission', '/user/edit', 'user:update', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('24', '用户删除', 'permission', '/user/delete', 'user:delete', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('25', '用户查询', 'permission', '/user/query', 'user:query', '21', '0/1/21', null, '1');
INSERT INTO `sys_permission` VALUES ('26', '用户列表', 'permission', '/user/list', 'user:list', '21', '0/1/21', null, '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(128) NOT NULL,
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f28', '商品管理员', '1');
INSERT INTO `sys_role` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f28', '用户管理员', '1');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(36) NOT NULL,
  `sys_role_id` varchar(32) NOT NULL COMMENT '角色id',
  `sys_permission_id` varchar(32) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f21', 'ebc8a441-c6f9-11e4-b137-0adc305c', '12');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f22', 'ebc8a441-c6f9-11e4-b137-0adc305c', '11');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f24', 'ebc9d647-c6f9-11e4-b137-0adc305c', '21');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f25', 'ebc8a441-c6f9-11e4-b137-0adc305c', '15');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f28', 'ebc9d647-c6f9-11e4-b137-0adc305c', '24');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f29', 'ebc9d647-c6f9-11e4-b137-0adc305c', '25');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f30', 'ebc9d647-c6f9-11e4-b137-0adc305c', '26');
INSERT INTO `sys_role_permission` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f23', 'ebc9d647-c6f9-11e4-b137-0adc305c', '22');
INSERT INTO `sys_role_permission` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f26', 'ebc8a441-c6f9-11e4-b137-0adc305c', '13');
INSERT INTO `sys_role_permission` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f27', 'ebc9d647-c6f9-11e4-b137-0adc305c', '23');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `usercode` varchar(32) NOT NULL COMMENT '账号',
  `username` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('lisi', 'lisi', '李四', 'a954a76b34901a8be5839775cea7167a', 'uiwueylm', '0');
INSERT INTO `sys_user` VALUES ('zhangsan', 'zhangsan', '张三', 'e10adc3949ba59abbe56e057f20f883e', 'eteokues', '0');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `sys_user_id` varchar(32) NOT NULL,
  `sys_role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f28', 'zhangsan', 'ebc8a441-c6f9-11e4-b137-0adc305c');
INSERT INTO `sys_user_role` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f28', 'lisi', 'ebc9d647-c6f9-11e4-b137-0adc305c');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `createDateTime` datetime DEFAULT NULL,
  `modifyDateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username_uni` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '2016-01-19 21:58:00', '2016-01-06 01:22:19');
INSERT INTO `user` VALUES ('2', 'admin1', 'admin1', '2016-01-20 00:00:00', '2016-01-21 23:22:15');
INSERT INTO `user` VALUES ('99', '李智', '**', '2016-01-20 01:20:53', '2016-01-13 01:22:11');
INSERT INTO `user` VALUES ('118', '446954852@qq.com', 'admin', '2016-01-13 02:02:00', '2016-01-14 00:00:00');
INSERT INTO `user` VALUES ('119', 'admin2', 'admin', '2016-01-13 01:22:23', '2016-01-21 01:22:28');
INSERT INTO `user` VALUES ('120', 'admin4', 'admin', '2016-01-07 01:25:06', '2016-01-06 01:22:32');
INSERT INTO `user` VALUES ('121', 'admin3', 'admin', '2016-01-22 01:25:16', '2016-01-12 01:25:12');
INSERT INTO `user` VALUES ('125', 'admin7', 'admin', '2016-01-05 01:25:21', '2016-01-20 01:25:27');
INSERT INTO `user` VALUES ('126', 'admin5', 'admin', '2016-02-03 01:25:40', '2016-01-07 21:25:29');
INSERT INTO `user` VALUES ('127', 'admin6', 'admin', '2015-12-28 00:00:00', '2016-01-14 01:25:35');
INSERT INTO `user` VALUES ('128', 'admin8', 'admin', '2016-01-14 00:00:00', '2016-01-13 01:25:56');
INSERT INTO `user` VALUES ('129', 'admin91', 'admin', '2016-01-07 00:00:00', '2016-01-21 01:26:08');
INSERT INTO `user` VALUES ('133', 'admin881', '李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智李智', '2016-02-02 00:00:00', '2016-02-18 16:52:58');
INSERT INTO `user` VALUES ('139', 'u', 'p', '2016-04-14 00:00:00', '2016-04-12 23:33:57');
INSERT INTO `user` VALUES ('140', 'u88991', 'p', '2016-05-26 00:00:00', '2016-05-26 22:32:07');
INSERT INTO `user` VALUES ('142', 'u222333777', 'p', '2016-05-29 00:02:00', '2016-05-29 22:21:46');
INSERT INTO `user` VALUES ('143', 'u2', 'p', '2016-05-29 23:14:23', '2016-05-29 23:14:23');
INSERT INTO `user` VALUES ('146', 'u999', 'p', '2016-06-01 00:13:52', '2016-06-01 00:13:52');
INSERT INTO `user` VALUES ('147', 'u9889', 'p', '2016-06-01 00:00:00', '2016-06-01 00:13:58');

# 账户申请表
drop table IF EXISTS mis_account_apply ;
CREATE TABLE `mis_account_apply` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`year` varchar(4)  COMMENT '年',
`month` varchar(2)  COMMENT '月',
`day` varchar(2)  COMMENT '日',
`accountDate` varchar(10)  COMMENT '账务日期',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 账户明细表
drop table IF EXISTS mis_account_detail ;
CREATE TABLE `mis_account_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `applyId` int(11) COMMENT '账务申请主键',
  `typeId` int(11) COMMENT '账务类型',
  `price` DOUBLE COMMENT '价格',
  `remark` varchar(1000) COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 账户类型表
drop table IF EXISTS mis_account_type ;
CREATE TABLE `mis_account_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) COMMENT '名称',
  `type` varchar(10) COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 1：出账 2：入账
delete from mis_account_type;
INSERT INTO mis_account_type(name, type) VALUE ('工资','2');
INSERT INTO mis_account_type(name, type) VALUE ('补助','2');
INSERT INTO mis_account_type(name, type) VALUE ('其他','2');

INSERT INTO mis_account_type(name, type) VALUE ('家里饮食','1');
INSERT INTO mis_account_type(name, type) VALUE ('baby存钱','1');
INSERT INTO mis_account_type(name, type) VALUE ('水电气','1');
INSERT INTO mis_account_type(name, type) VALUE ('日杂百货','1');
INSERT INTO mis_account_type(name, type) VALUE ('交通','1');
INSERT INTO mis_account_type(name, type) VALUE ('医疗','1');
INSERT INTO mis_account_type(name, type) VALUE ('通讯','1');
INSERT INTO mis_account_type(name, type) VALUE ('衣物','1');
INSERT INTO mis_account_type(name, type) VALUE ('外面吃喝','1');
INSERT INTO mis_account_type(name, type) VALUE ('教育学习','1');
INSERT INTO mis_account_type(name, type) VALUE ('保险','1');
INSERT INTO mis_account_type(name, type) VALUE ('护肤理发','1');
INSERT INTO mis_account_type(name, type) VALUE ('礼尚往来','1');
INSERT INTO mis_account_type(name, type) VALUE ('其他','1');

# 枚举表
drop table IF EXISTS mis_enum ;
CREATE TABLE `mis_enum` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `catalog` varchar(100)  COMMENT '模块',
  `type` varchar(100)  COMMENT '类型',
  `name` varchar(10)  COMMENT '名称',
  `value` varchar(100)  COMMENT '值',
  `remark` varchar(1000)  COMMENT '描述',
  `sort` varchar(1)  COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 出入账类型
delete from mis_enum where catalog='account'and type='accountType';
INSERT INTO mis_enum(catalog, type, name, value, remark, sort) VALUE ('account','accountType','出账','1','','1');
INSERT INTO mis_enum(catalog, type, name, value, remark, sort) VALUE ('account','accountType','入账','2','','2');

# 菜单表
drop table IF EXISTS mis_menu ;
CREATE TABLE `mis_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) COMMENT '名称',
  `url` varchar(100)  COMMENT 'url',
  `sort` varchar(1)  COMMENT '排序',
  `parentId` int(11)  COMMENT '上级菜单',
  `imgName` VARCHAR(100)  COMMENT '样式图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mis_menu` VALUES (1, '账务管理', '', '1',  0, 'icon01.png');
INSERT INTO `mis_menu` VALUES (2, '系统设置', '', '2',  0, 'icon06.png');
INSERT INTO `mis_menu` VALUES (3, '系统管理', '', '1',  2, 'leftico01.png');
INSERT INTO `mis_menu` VALUES (4, '运营管理', '', '2',  2, 'leftico02.png');
INSERT INTO `mis_menu` VALUES (5, '角色管理', 'role/list', '1',  3, NULL);
INSERT INTO `mis_menu` VALUES (6, '枚举管理', 'enum/list', '2',  3, NULL);
INSERT INTO `mis_menu` VALUES (7, '菜单管理', 'menu/list', '3',  3, NULL);
INSERT INTO `mis_menu` VALUES (8, '用户管理', 'user/list', '1',  4, NULL);
INSERT INTO `mis_menu` VALUES (9, '账务类型管理', 'account/type/list', '2',  4, NULL);
INSERT INTO `mis_menu` VALUES (11, '账务维护', '', '1',  1, 'leftico03.png');
INSERT INTO `mis_menu` VALUES (12, '账务记录', 'account/list', '1',  11, '');
INSERT INTO `mis_menu` VALUES (13, '角色菜单权限配置', 'menu/menu-role', '3',  4, '');

# 角色表
drop table IF EXISTS mis_role ;
CREATE TABLE `mis_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) COMMENT '角色名称',
  `remark` varchar(1000) COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from mis_role;
insert into mis_role(name, remark) VALUE ('管理员','系统管理员，拥有所有系统权限');

# 菜单角色表
drop table IF EXISTS mis_role_menu;
CREATE TABLE `mis_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) COMMENT '角色id',
  `menuId` int(11) COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 用户表
drop table IF EXISTS mis_user ;
CREATE TABLE `mis_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `showName` varchar(100)  COMMENT '显示名称',
  `userName` varchar(100)  COMMENT '登录名称',
  `password` varchar(100)  COMMENT '密码',
  `roleId` int(11)  COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from mis_user;
insert into mis_user(showName, userName, password, roleId) VALUE ('管理员','admin','1',1);
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

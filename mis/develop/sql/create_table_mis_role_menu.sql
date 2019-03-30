# 菜单角色表
drop table IF EXISTS mis_role_menu;
CREATE TABLE `mis_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) COMMENT '角色id',
  `menuId` int(11) COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
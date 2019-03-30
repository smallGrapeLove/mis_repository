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
insert into mis_role(name, remark) VALUE ('账务记录','拥有账务记录部分的权限');
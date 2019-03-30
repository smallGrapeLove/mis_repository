# 用户表
drop table IF EXISTS mis_user ;
CREATE TABLE `mis_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `showName` varchar(100)  COMMENT '显示名称',
  `userName` varchar(100)  COMMENT '登陆名称',
  `password` varchar(100)  COMMENT '密码',
  `roleId` int(11)  COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from mis_user;
insert into mis_user(showName, userName, password, roleId) VALUE ('管理员','admin','1',1);
insert into mis_user(showName, userName, password, roleId) VALUE ('徐欢','huan.xu','1',2);
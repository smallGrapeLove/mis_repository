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


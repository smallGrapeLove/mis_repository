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

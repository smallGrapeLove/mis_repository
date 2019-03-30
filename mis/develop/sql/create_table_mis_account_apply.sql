# 账户申请表
drop table IF EXISTS mis_account_apply ;
CREATE TABLE `mis_account_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` varchar(4)  COMMENT '年',
  `month` varchar(2)  COMMENT '月',
  `day` varchar(2)  COMMENT '日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



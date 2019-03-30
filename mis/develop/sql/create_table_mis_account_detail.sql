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

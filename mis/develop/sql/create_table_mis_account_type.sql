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
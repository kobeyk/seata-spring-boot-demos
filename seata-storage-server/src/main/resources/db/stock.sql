DROP TABLE IF EXISTS `t_storage`;
CREATE TABLE `t_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_code` varchar(255) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `count` int(11) DEFAULT '0' COMMENT '商品库存数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `commodity_code` (`commodity_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `t_storage` VALUES ('1', 'C201901140001', '水杯', '1000');

-- 每个本地事务库，都需要建一张这个表
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL COMMENT '分支事务ID',
  `xid` varchar(100) NOT NULL COMMENT '全局事务ID',
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
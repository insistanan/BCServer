CREATE TABLE `bc_mealservermode` (
                                     `id` bigint(20) NOT NULL COMMENT 'id',


                                     `server_mode` char(1) DEFAULT '' COMMENT '1-自选开餐，2-每日开餐，3-周日不开餐，4-周一到周五开餐',
                                     `server_day` varchar(32) DEFAULT '' COMMENT '开餐时间，1-7代表周一到周日',
                                     `early_day` int(10) NULL DEFAULT 7 COMMENT '可提前报餐天数',

                                     `del_flag` char(1) NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                     `create_dept` bigint(20) NULL DEFAULT NULL COMMENT '创建部门',
                                     `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
                                     `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
                                     `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                     `tenant_id` varchar(20)  NOT NULL COMMENT '租户编号',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='开餐模式信息表';

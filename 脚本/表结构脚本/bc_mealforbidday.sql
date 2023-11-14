CREATE TABLE `bc_mealforbidday` (
                                    `id` bigint(20) NOT NULL COMMENT 'id',


                                    `forbid_date` datetime(0) not NULL COMMENT '禁止用餐日期',
                                    `forbid_type` varchar(32) DEFAULT '不开餐' COMMENT '类型',

                                    `del_flag` char(1) NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                    `create_dept` bigint(20) NULL DEFAULT NULL COMMENT '创建部门',
                                    `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
                                    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                    `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
                                    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                    `tenant_id` varchar(20)  NOT NULL COMMENT '租户编号',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='禁止用餐日期表';

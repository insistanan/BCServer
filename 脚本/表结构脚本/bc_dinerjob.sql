CREATE TABLE `bc_dinerjob` (
                               `id` bigint(20) NOT NULL COMMENT 'id',


                               `job_name` varchar(32) DEFAULT '' COMMENT '职位名称',
                               `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
                               `status` char(1) NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',

                               `del_flag` char(1) NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                               `create_dept` bigint(20) NULL DEFAULT NULL COMMENT '创建部门',
                               `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
                               `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                               `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
                               `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                               `tenant_id` varchar(20)  NOT NULL COMMENT '租户编号',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用餐人员职位表';

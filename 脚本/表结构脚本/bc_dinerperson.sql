CREATE TABLE `bc_dinerperson` (
                                  `id` bigint(20) NOT NULL COMMENT 'id',

                                  `person_canteen` varchar(32) DEFAULT '' COMMENT '所属餐厅',
                                  `person_code` varchar(32) DEFAULT '' COMMENT '工号',
                                  `person_name` varchar(32) DEFAULT '' COMMENT '昵称',
                                  `person_tel` varchar(32) DEFAULT '' COMMENT '手机号',
                                  `person_cardno` varchar(32) DEFAULT '' COMMENT '职工卡号',
                                  `person_dinerdeptid` bigint(20) NULL DEFAULT NULL COMMENT '部门',
                                  `person_dinerjobid` bigint(20) NULL DEFAULT NULL COMMENT '职务',
                                  `person_headimg` bigint(20) NULL DEFAULT NULL COMMENT '头像',

                                  `status` char(1) NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',

                                  `del_flag` char(1) NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                  `create_dept` bigint(20) NULL DEFAULT NULL COMMENT '创建部门',
                                  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
                                  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
                                  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                  `tenant_id` varchar(20)  NOT NULL COMMENT '租户编号',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用餐人员信息表';

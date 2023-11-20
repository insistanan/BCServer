CREATE TABLE `bc_mealstatistic` (
  `id` bigint(20) NOT NULL COMMENT 'id',

  food_grounding varchar(32) DEFAULT '' COMMENT '用餐时段',
  dept_id bigint(20) comment '部门。部门id',
  job_id bigint(20) comment '职务。职务id',
  food_name varchar(32) comment '餐品名称',
  dinner_status char(1) default '0' comment '用餐状态(0待用餐，1已用餐，2退款，3其他)',
  bc_time datetime comment '报餐时间',


  `status` char(1) NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',

  `del_flag` char(1) NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_dept` bigint(20) NULL DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `tenant_id` varchar(20)  NOT NULL COMMENT '租户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='报餐明细表';


-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725426557628985345, '报餐明细', '1724019176173764609', '1', 'mealdetail', 'mealmanage/mealdetail/index', 1, 0, 'C', '0', '0', 'mealmanage:mealdetail:list', '#', 103, 1, sysdate(), null, null, '报餐明细菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725426557628985346, '报餐明细查询', 1725426557628985345, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdetail:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725426557628985347, '报餐明细新增', 1725426557628985345, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdetail:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725426557628985348, '报餐明细修改', 1725426557628985345, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdetail:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725426557628985349, '报餐明细删除', 1725426557628985345, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdetail:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725426557628985350, '报餐明细导出', 1725426557628985345, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdetail:export',       '#', 103, 1, sysdate(), null, null, '');

-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723959036229824514, '部门设置', '1723957243361996802', '1', 'dinerdept', 'dinermanage/dinerdept/index', 1, 0, 'C', '0', '0', 'dinermanage:dinerdept:list', '#', 103, 1, sysdate(), null, null, '用餐人员部门菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723959036229824515, '用餐人员部门查询', 1723959036229824514, '1',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerdept:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723959036229824516, '用餐人员部门新增', 1723959036229824514, '2',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerdept:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723959036229824517, '用餐人员部门修改', 1723959036229824514, '3',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerdept:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723959036229824518, '用餐人员部门删除', 1723959036229824514, '4',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerdept:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723959036229824519, '用餐人员部门导出', 1723959036229824514, '5',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerdept:export',       '#', 103, 1, sysdate(), null, null, '');

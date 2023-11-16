-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016724208361473, '菜品库', '1724019176173764609', '5', 'mealfoods', 'mealmanage/mealfoods/index', 1, 0, 'C', '0', '0', 'mealmanage:mealfoods:list', '#', 103, 1, sysdate(), null, null, '菜品菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016724208361474, '菜品查询', 1725016724208361473, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoods:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016724208361475, '菜品新增', 1725016724208361473, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoods:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016724208361476, '菜品修改', 1725016724208361473, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoods:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016724208361477, '菜品删除', 1725016724208361473, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoods:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016724208361478, '菜品导出', 1725016724208361473, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoods:export',       '#', 103, 1, sysdate(), null, null, '');

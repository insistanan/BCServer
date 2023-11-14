-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390582711582722, '开餐模式信息', '1724019176173764609', '1', 'mealservermode', 'mealmanage/mealservermode/index', 1, 0, 'C', '0', '0', 'mealmanage:mealservermode:list', '#', 103, 1, sysdate(), null, null, '开餐模式信息菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390582711582723, '开餐模式信息查询', 1724390582711582722, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservermode:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390582711582724, '开餐模式信息新增', 1724390582711582722, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservermode:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390582711582725, '开餐模式信息修改', 1724390582711582722, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservermode:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390582711582726, '开餐模式信息删除', 1724390582711582722, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservermode:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390582711582727, '开餐模式信息导出', 1724390582711582722, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservermode:export',       '#', 103, 1, sysdate(), null, null, '');

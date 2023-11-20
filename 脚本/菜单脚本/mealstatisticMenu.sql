-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725781976456716290, '报餐统计', '1724019176173764609', '1', 'mealstatistic', 'mealmanage/mealstatistic/index', 1, 0, 'C', '0', '0', 'mealmanage:mealstatistic:list', '#', 103, 1, sysdate(), null, null, '报餐统计菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725781976456716291, '报餐统计查询', 1725781976456716290, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealstatistic:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725781976456716292, '报餐统计新增', 1725781976456716290, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealstatistic:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725781976456716293, '报餐统计修改', 1725781976456716290, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealstatistic:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725781976456716294, '报餐统计删除', 1725781976456716290, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealstatistic:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725781976456716295, '报餐统计导出', 1725781976456716290, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealstatistic:export',       '#', 103, 1, sysdate(), null, null, '');

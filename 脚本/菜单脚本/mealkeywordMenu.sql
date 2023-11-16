-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026494038499330, '关键词列表', '1724019176173764609', '10', 'mealkeyword', 'mealmanage/mealkeyword/index', 1, 0, 'C', '0', '0', 'mealmanage:mealkeyword:list', '#', 103, 1, sysdate(), null, null, '关键词菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026494038499331, '关键词查询', 1725026494038499330, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealkeyword:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026494038499332, '关键词新增', 1725026494038499330, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealkeyword:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026494038499333, '关键词修改', 1725026494038499330, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealkeyword:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026494038499334, '关键词删除', 1725026494038499330, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealkeyword:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026494038499335, '关键词导出', 1725026494038499330, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealkeyword:export',       '#', 103, 1, sysdate(), null, null, '');

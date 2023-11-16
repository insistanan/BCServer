-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725023106110414850, '菜品类型', '1724019176173764609', '4', 'mealfoodtype', 'mealmanage/mealfoodtype/index', 1, 0, 'C', '0', '0', 'mealmanage:mealfoodtype:list', '#', 103, 1, sysdate(), null, null, '菜品类型菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725023106110414851, '菜品类型查询', 1725023106110414850, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoodtype:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725023106110414852, '菜品类型新增', 1725023106110414850, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoodtype:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725023106110414853, '菜品类型修改', 1725023106110414850, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoodtype:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725023106110414854, '菜品类型删除', 1725023106110414850, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoodtype:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725023106110414855, '菜品类型导出', 1725023106110414850, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealfoodtype:export',       '#', 103, 1, sysdate(), null, null, '');

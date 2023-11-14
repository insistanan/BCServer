-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390577875550209, '禁止用餐日期', '1724019176173764609', '2', 'mealforbidday', 'mealmanage/mealforbidday/index', 1, 0, 'C', '0', '0', 'mealmanage:mealforbidday:list', '#', 103, 1, sysdate(), null, null, '禁止用餐日期菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390577875550210, '禁止用餐日期查询', 1724390577875550209, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealforbidday:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390577875550211, '禁止用餐日期新增', 1724390577875550209, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealforbidday:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390577875550212, '禁止用餐日期修改', 1724390577875550209, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealforbidday:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390577875550213, '禁止用餐日期删除', 1724390577875550209, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealforbidday:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1724390577875550214, '禁止用餐日期导出', 1724390577875550209, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealforbidday:export',       '#', 103, 1, sysdate(), null, null, '');

-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016731766497282, '用餐时段', '1724019176173764609', '3', 'mealservetime', 'mealmanage/mealservetime/index', 1, 0, 'C', '0', '0', 'mealmanage:mealservetime:list', '#', 103, 1, sysdate(), null, null, '用餐时段菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016731766497283, '用餐时段查询', 1725016731766497282, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservetime:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016731766497284, '用餐时段新增', 1725016731766497282, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservetime:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016731766497285, '用餐时段修改', 1725016731766497282, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservetime:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016731766497286, '用餐时段删除', 1725016731766497282, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservetime:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725016731766497287, '用餐时段导出', 1725016731766497282, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealservetime:export',       '#', 103, 1, sysdate(), null, null, '');

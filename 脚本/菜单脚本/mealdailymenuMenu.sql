-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725367729316024321, '每日菜谱', '1724019176173764609', '6', 'mealdailymenu', 'mealmanage/mealdailymenu/index', 1, 0, 'C', '0', '0', 'mealmanage:mealdailymenu:list', '#', 103, 1, sysdate(), null, null, '每日菜谱菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725367729316024322, '每日菜谱查询', 1725367729316024321, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdailymenu:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725367729316024323, '每日菜谱新增', 1725367729316024321, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdailymenu:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725367729316024324, '每日菜谱修改', 1725367729316024321, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdailymenu:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725367729316024325, '每日菜谱删除', 1725367729316024321, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdailymenu:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725367729316024326, '每日菜谱导出', 1725367729316024321, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealdailymenu:export',       '#', 103, 1, sysdate(), null, null, '');

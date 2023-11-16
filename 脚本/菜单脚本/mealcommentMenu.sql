-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026509423206402, '评论列表', '1724019176173764609', '9', 'mealcomment', 'mealmanage/mealcomment/index', 1, 0, 'C', '0', '0', 'mealmanage:mealcomment:list', '#', 103, 1, sysdate(), null, null, '评论菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026509423206403, '评论查询', 1725026509423206402, '1',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealcomment:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026509423206404, '评论新增', 1725026509423206402, '2',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealcomment:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026509423206405, '评论修改', 1725026509423206402, '3',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealcomment:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026509423206406, '评论删除', 1725026509423206402, '4',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealcomment:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1725026509423206407, '评论导出', 1725026509423206402, '5',  '#', '', 1, 0, 'F', '0', '0', 'mealmanage:mealcomment:export',       '#', 103, 1, sysdate(), null, null, '');

-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982772949483521, '免审核人员', '1723957243361996802', '4', 'dinernoreview', 'dinermanage/dinernoreview/index', 1, 0, 'C', '0', '0', 'dinermanage:dinernoreview:list', '#', 103, 1, sysdate(), null, null, '免审核人员菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982772949483522, '免审核人员查询', 1723982772949483521, '1',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinernoreview:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982772949483523, '免审核人员新增', 1723982772949483521, '2',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinernoreview:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982772949483524, '免审核人员修改', 1723982772949483521, '3',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinernoreview:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982772949483525, '免审核人员删除', 1723982772949483521, '4',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinernoreview:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982772949483526, '免审核人员导出', 1723982772949483521, '5',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinernoreview:export',       '#', 103, 1, sysdate(), null, null, '');

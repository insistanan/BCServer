-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982777315753986, '用餐人员信息', '1723957243361996802', '3', 'dinerperson', 'dinermanage/dinerperson/index', 1, 0, 'C', '0', '0', 'dinermanage:dinerperson:list', '#', 103, 1, sysdate(), null, null, '用餐人员信息菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982777315753987, '用餐人员信息查询', 1723982777315753986, '1',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerperson:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982777315753988, '用餐人员信息新增', 1723982777315753986, '2',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerperson:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982777315753989, '用餐人员信息修改', 1723982777315753986, '3',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerperson:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982777315753990, '用餐人员信息删除', 1723982777315753986, '4',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerperson:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982777315753991, '用餐人员信息导出', 1723982777315753986, '5',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerperson:export',       '#', 103, 1, sysdate(), null, null, '');

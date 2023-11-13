-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982770038636546, '职务设置', '1723957243361996802', '2', 'dinerjob', 'dinermanage/dinerjob/index', 1, 0, 'C', '0', '0', 'dinermanage:dinerjob:list', '#', 103, 1, sysdate(), null, null, '职务设置菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982770038636547, '职务设置查询', 1723982770038636546, '1',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerjob:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982770038636548, '职务设置新增', 1723982770038636546, '2',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerjob:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982770038636549, '职务设置修改', 1723982770038636546, '3',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerjob:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982770038636550, '职务设置删除', 1723982770038636546, '4',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerjob:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1723982770038636551, '职务设置导出', 1723982770038636546, '5',  '#', '', 1, 0, 'F', '0', '0', 'dinermanage:dinerjob:export',       '#', 103, 1, sysdate(), null, null, '');

INSERT INTO sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark) VALUES (1726237268287258625, '系统展示', 0, 3, 'systemshow', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'color', 103, 1, '2023-11-19 21:53:31', 1, '2023-11-19 21:53:31', '');


-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242275304767489, '公告', '1726237268287258625', '1', 'systemshownotice', 'systemshow/systemshownotice/index', 1, 0, 'C', '0', '0', 'systemshow:systemshownotice:list', '#', 103, 1, sysdate(), null, null, '公告菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242275304767490, '公告查询', 1726242275304767489, '1',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshownotice:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242275304767491, '公告新增', 1726242275304767489, '2',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshownotice:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242275304767492, '公告修改', 1726242275304767489, '3',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshownotice:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242275304767493, '公告删除', 1726242275304767489, '4',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshownotice:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242275304767494, '公告导出', 1726242275304767489, '5',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshownotice:export',       '#', 103, 1, sysdate(), null, null, '');

-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242272490389506, '菜谱图片', '1726237268287258625', '2', 'systemshowmenupic', 'systemshow/systemshowmenupic/index', 1, 0, 'C', '0', '0', 'systemshow:systemshowmenupic:list', '#', 103, 1, sysdate(), null, null, '菜谱图片菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242272490389507, '菜谱图片查询', 1726242272490389506, '1',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowmenupic:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242272490389508, '菜谱图片新增', 1726242272490389506, '2',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowmenupic:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242272490389509, '菜谱图片修改', 1726242272490389506, '3',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowmenupic:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242272490389510, '菜谱图片删除', 1726242272490389506, '4',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowmenupic:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242272490389511, '菜谱图片导出', 1726242272490389506, '5',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowmenupic:export',       '#', 103, 1, sysdate(), null, null, '');

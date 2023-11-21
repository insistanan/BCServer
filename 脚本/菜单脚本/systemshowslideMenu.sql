-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242279859781633, '首页幻灯片', '1726237268287258625', '3', 'systemshowslide', 'systemshow/systemshowslide/index', 1, 0, 'C', '0', '0', 'systemshow:systemshowslide:list', '#', 103, 1, sysdate(), null, null, '首页幻灯片菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242279859781634, '首页幻灯片查询', 1726242279859781633, '1',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowslide:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242279859781635, '首页幻灯片新增', 1726242279859781633, '2',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowslide:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242279859781636, '首页幻灯片修改', 1726242279859781633, '3',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowslide:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242279859781637, '首页幻灯片删除', 1726242279859781633, '4',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowslide:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726242279859781638, '首页幻灯片导出', 1726242279859781633, '5',  '#', '', 1, 0, 'F', '0', '0', 'systemshow:systemshowslide:export',       '#', 103, 1, sysdate(), null, null, '');

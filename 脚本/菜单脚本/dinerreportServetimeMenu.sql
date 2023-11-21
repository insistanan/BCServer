-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831844811202561, '时段就餐统计', '1726772600648790018', '1', 'dinerreportServetime', 'dinerreport/dinerreportServetime/index', 1, 0, 'C', '0', '0', 'dinerreport:dinerreportServetime:list', '#', 103, 1, sysdate(), null, null, '时段就餐统计菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831844811202562, '时段就餐统计查询', 1726831844811202561, '1',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportServetime:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831844811202563, '时段就餐统计新增', 1726831844811202561, '2',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportServetime:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831844811202564, '时段就餐统计修改', 1726831844811202561, '3',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportServetime:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831844811202565, '时段就餐统计删除', 1726831844811202561, '4',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportServetime:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831844811202566, '时段就餐统计导出', 1726831844811202561, '5',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportServetime:export',       '#', 103, 1, sysdate(), null, null, '');

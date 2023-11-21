-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831841493508098, '未实际就餐统计', '1726772600648790018', '2', 'dinerreportPerson', 'dinerreport/dinerreportPerson/index', 1, 0, 'C', '0', '0', 'dinerreport:dinerreportPerson:list', '#', 103, 1, sysdate(), null, null, '未实际就餐统计菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831841493508099, '未实际就餐统计查询', 1726831841493508098, '1',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportPerson:query',        '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831841493508100, '未实际就餐统计新增', 1726831841493508098, '2',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportPerson:add',          '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831841493508101, '未实际就餐统计修改', 1726831841493508098, '3',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportPerson:edit',         '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831841493508102, '未实际就餐统计删除', 1726831841493508098, '4',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportPerson:remove',       '#', 103, 1, sysdate(), null, null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_dept, create_by, create_time, update_by, update_time, remark)
values(1726831841493508103, '未实际就餐统计导出', 1726831841493508098, '5',  '#', '', 1, 0, 'F', '0', '0', 'dinerreport:dinerreportPerson:export',       '#', 103, 1, sysdate(), null, null, '');

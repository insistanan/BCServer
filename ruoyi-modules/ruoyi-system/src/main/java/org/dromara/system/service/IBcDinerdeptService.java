package org.dromara.system.service;


import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcDinerdeptBo;
import org.dromara.system.domain.vo.BcDinerdeptVo;

import java.util.Collection;
import java.util.List;

/**
 * 用餐人员部门Service接口
 *
 * @author 周强
 * @date 2023-11-13
 */
public interface IBcDinerdeptService {

    /**
     * 查询用餐人员部门
     */
    BcDinerdeptVo queryById(Long id);

    /**
     * 查询用餐人员部门列表
     */
    TableDataInfo<BcDinerdeptVo> queryPageList(BcDinerdeptBo bo, PageQuery pageQuery);

    /**
     * 查询用餐人员部门列表
     */
    List<BcDinerdeptVo> queryList(BcDinerdeptBo bo);

    /**
     * 新增用餐人员部门
     */
    Boolean insertByBo(BcDinerdeptBo bo);

    /**
     * 修改用餐人员部门
     */
    Boolean updateByBo(BcDinerdeptBo bo);

    /**
     * 校验并批量删除用餐人员部门信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

package org.dromara.system.service;


import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcDinerpersonBo;
import org.dromara.system.domain.vo.BcDinerpersonVo;

import java.util.Collection;
import java.util.List;

/**
 * 用餐人员信息Service接口
 *
 * @author Lion Li
 * @date 2023-11-13
 */
public interface IBcDinerpersonService {

    /**
     * 查询用餐人员信息
     */
    BcDinerpersonVo queryById(Long id);

    /**
     * 查询用餐人员信息列表
     */
    TableDataInfo<BcDinerpersonVo> queryPageList(BcDinerpersonBo bo, PageQuery pageQuery);

    /**
     * 查询用餐人员信息列表
     */
    List<BcDinerpersonVo> queryList(BcDinerpersonBo bo);

    /**
     * 新增用餐人员信息
     */
    Boolean insertByBo(BcDinerpersonBo bo);

    /**
     * 修改用餐人员信息
     */
    Boolean updateByBo(BcDinerpersonBo bo);

    /**
     * 校验并批量删除用餐人员信息信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

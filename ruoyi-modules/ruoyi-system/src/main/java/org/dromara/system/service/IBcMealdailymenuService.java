package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcMealdailymenuBo;
import org.dromara.system.domain.vo.BcMealdailymenuVo;

import java.util.Collection;
import java.util.List;

/**
 * 每日菜谱Service接口
 *
 * @author 周强
 * @date 2023-11-17
 */
public interface IBcMealdailymenuService {

    /**
     * 查询每日菜谱
     */
    BcMealdailymenuVo queryById(Long id);

    /**
     * 查询每日菜谱列表
     */
    TableDataInfo<BcMealdailymenuVo> queryPageList(BcMealdailymenuBo bo, PageQuery pageQuery);

    /**
     * 查询每日菜谱列表
     */
    List<BcMealdailymenuVo> queryList(BcMealdailymenuBo bo);

    /**
     * 新增每日菜谱
     */
    Boolean insertByBo(BcMealdailymenuBo bo);

    /**
     * 修改每日菜谱
     */
    Boolean updateByBo(BcMealdailymenuBo bo);

    /**
     * 校验并批量删除每日菜谱信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

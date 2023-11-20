package org.dromara.system.service;

import org.dromara.system.domain.BcMealstatistic;
import org.dromara.system.domain.vo.BcMealstatisticVo;
import org.dromara.system.domain.bo.BcMealstatisticBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 报餐统计Service接口
 *
 * @author anan
 * @date 2023-11-18
 */
public interface IBcMealstatisticService {

    /**
     * 查询报餐统计
     */
    BcMealstatisticVo queryById(Long id);

    /**
     * 查询报餐统计列表
     */
    TableDataInfo<BcMealstatisticVo> queryPageList(BcMealstatisticBo bo, PageQuery pageQuery);

    /**
     * 查询报餐统计列表
     */
    List<BcMealstatisticVo> queryList(BcMealstatisticBo bo);

    /**
     * 新增报餐统计
     */
    Boolean insertByBo(BcMealstatisticBo bo);

    /**
     * 修改报餐统计
     */
    Boolean updateByBo(BcMealstatisticBo bo);

    /**
     * 校验并批量删除报餐统计信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

package org.dromara.system.service;

import org.dromara.system.domain.BcDinerreportServetime;
import org.dromara.system.domain.vo.BcDinerreportServetimeVo;
import org.dromara.system.domain.bo.BcDinerreportServetimeBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 时段就餐统计Service接口
 *
 * @author 周强
 * @date 2023-11-21
 */
public interface IBcDinerreportServetimeService {

    /**
     * 查询时段就餐统计
     */
    BcDinerreportServetimeVo queryById(Long id);

    /**
     * 查询时段就餐统计列表
     */
    TableDataInfo<BcDinerreportServetimeVo> queryPageList(BcDinerreportServetimeBo bo, PageQuery pageQuery);

    /**
     * 查询时段就餐统计列表
     */
    List<BcDinerreportServetimeVo> queryList(BcDinerreportServetimeBo bo);

    List<BcDinerreportServetimeVo> queryDinerreportServetime(BcDinerreportServetimeBo bo);

    /**
     * 新增时段就餐统计
     */
    Boolean insertByBo(BcDinerreportServetimeBo bo);

    /**
     * 修改时段就餐统计
     */
    Boolean updateByBo(BcDinerreportServetimeBo bo);

    /**
     * 校验并批量删除时段就餐统计信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

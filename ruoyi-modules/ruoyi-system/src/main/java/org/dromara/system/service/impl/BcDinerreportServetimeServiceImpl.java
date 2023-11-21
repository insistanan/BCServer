package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcDinerreportServetime;
import org.dromara.system.domain.bo.BcDinerreportServetimeBo;
import org.dromara.system.domain.vo.BcDinerreportServetimeVo;
import org.dromara.system.mapper.BcDinerreportServetimeMapper;
import org.dromara.system.service.IBcDinerreportServetimeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 时段就餐统计Service业务层处理
 *
 * @author 周强
 * @date 2023-11-21
 */
@RequiredArgsConstructor
@Service
public class BcDinerreportServetimeServiceImpl implements IBcDinerreportServetimeService {

    private final BcDinerreportServetimeMapper baseMapper;

    /**
     * 查询时段就餐统计
     */
    @Override
    public BcDinerreportServetimeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询时段就餐统计列表
     */
    @Override
    public TableDataInfo<BcDinerreportServetimeVo> queryPageList(BcDinerreportServetimeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcDinerreportServetime> lqw = buildQueryWrapper(bo);
        Page<BcDinerreportServetimeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询时段就餐统计列表
     */
    @Override
    public List<BcDinerreportServetimeVo> queryList(BcDinerreportServetimeBo bo) {
        LambdaQueryWrapper<BcDinerreportServetime> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    @Override
    public List<BcDinerreportServetimeVo> queryDinerreportServetime(BcDinerreportServetimeBo bo) {

        return baseMapper.queryDinerreportServetime(DateUtils.parseDate(bo.getBegindate()), DateUtils.parseDate(bo.getEnddate()));
    }

    private LambdaQueryWrapper<BcDinerreportServetime> buildQueryWrapper(BcDinerreportServetimeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcDinerreportServetime> lqw = Wrappers.lambdaQuery();
        return lqw;
    }

    /**
     * 新增时段就餐统计
     */
    @Override
    public Boolean insertByBo(BcDinerreportServetimeBo bo) {
        return true;
    }

    /**
     * 修改时段就餐统计
     */
    @Override
    public Boolean updateByBo(BcDinerreportServetimeBo bo) {
        return true;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcDinerreportServetime entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除时段就餐统计
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return true;
    }
}

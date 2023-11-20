package org.dromara.system.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dromara.system.domain.bo.BcMealstatisticBo;
import org.dromara.system.domain.vo.BcMealstatisticVo;
import org.dromara.system.domain.BcMealstatistic;
import org.dromara.system.mapper.BcMealstatisticMapper;
import org.dromara.system.service.IBcMealstatisticService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 报餐统计Service业务层处理
 *
 * @author anan
 * @date 2023-11-18
 */
@RequiredArgsConstructor
@Service
public class BcMealstatisticServiceImpl implements IBcMealstatisticService {

    private final BcMealstatisticMapper baseMapper;

    /**
     * 查询报餐统计
     */
    @Override
    public BcMealstatisticVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询报餐统计列表
     */
    @Override
    public TableDataInfo<BcMealstatisticVo> queryPageList(BcMealstatisticBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealstatistic> lqw = buildQueryWrapper(bo);
        Page<BcMealstatisticVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询报餐统计列表
     */
    @Override
    public List<BcMealstatisticVo> queryList(BcMealstatisticBo bo) {
        LambdaQueryWrapper<BcMealstatistic> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealstatistic> buildQueryWrapper(BcMealstatisticBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealstatistic> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getFoodGrounding()), BcMealstatistic::getFoodGrounding, bo.getFoodGrounding());
        lqw.eq(bo.getDeptId() != null, BcMealstatistic::getDeptId, bo.getDeptId());
        lqw.eq(bo.getJobId() != null, BcMealstatistic::getJobId, bo.getJobId());
        lqw.like(StringUtils.isNotBlank(bo.getFoodName()), BcMealstatistic::getFoodName, bo.getFoodName());
        lqw.eq(bo.getBcTime() != null, BcMealstatistic::getBcTime, bo.getBcTime());
        return lqw;
    }

    /**
     * 新增报餐统计
     */
    @Override
    public Boolean insertByBo(BcMealstatisticBo bo) {
        BcMealstatistic add = MapstructUtils.convert(bo, BcMealstatistic.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改报餐统计
     */
    @Override
    public Boolean updateByBo(BcMealstatisticBo bo) {
        BcMealstatistic update = MapstructUtils.convert(bo, BcMealstatistic.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealstatistic entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除报餐统计
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

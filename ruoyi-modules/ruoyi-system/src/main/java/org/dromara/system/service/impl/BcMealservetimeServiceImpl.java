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
import org.dromara.system.domain.bo.BcMealservetimeBo;
import org.dromara.system.domain.vo.BcMealservetimeVo;
import org.dromara.system.domain.BcMealservetime;
import org.dromara.system.mapper.BcMealservetimeMapper;
import org.dromara.system.service.IBcMealservetimeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 用餐时段Service业务层处理
 *
 * @author 周强
 * @date 2023-11-16
 */
@RequiredArgsConstructor
@Service
public class BcMealservetimeServiceImpl implements IBcMealservetimeService {

    private final BcMealservetimeMapper baseMapper;

    /**
     * 查询用餐时段
     */
    @Override
    public BcMealservetimeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询用餐时段列表
     */
    @Override
    public TableDataInfo<BcMealservetimeVo> queryPageList(BcMealservetimeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealservetime> lqw = buildQueryWrapper(bo);
        Page<BcMealservetimeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询用餐时段列表
     */
    @Override
    public List<BcMealservetimeVo> queryList(BcMealservetimeBo bo) {
        LambdaQueryWrapper<BcMealservetime> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealservetime> buildQueryWrapper(BcMealservetimeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealservetime> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getServetimeName()), BcMealservetime::getServetimeName, bo.getServetimeName());
        lqw.eq(bo.getServetimeNum() != null, BcMealservetime::getServetimeNum, bo.getServetimeNum());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeStatus()), BcMealservetime::getServetimeStatus, bo.getServetimeStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeBegin()), BcMealservetime::getServetimeBegin, bo.getServetimeBegin());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeEnd()), BcMealservetime::getServetimeEnd, bo.getServetimeEnd());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeRemindstatus()), BcMealservetime::getServetimeRemindstatus, bo.getServetimeRemindstatus());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeRemind()), BcMealservetime::getServetimeRemind, bo.getServetimeRemind());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeRepotrendday()), BcMealservetime::getServetimeRepotrendday, bo.getServetimeRepotrendday());
        lqw.eq(StringUtils.isNotBlank(bo.getServetimeRepotrendtime()), BcMealservetime::getServetimeRepotrendtime, bo.getServetimeRepotrendtime());
        return lqw;
    }

    /**
     * 新增用餐时段
     */
    @Override
    public Boolean insertByBo(BcMealservetimeBo bo) {
        BcMealservetime add = MapstructUtils.convert(bo, BcMealservetime.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改用餐时段
     */
    @Override
    public Boolean updateByBo(BcMealservetimeBo bo) {
        BcMealservetime update = MapstructUtils.convert(bo, BcMealservetime.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealservetime entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除用餐时段
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

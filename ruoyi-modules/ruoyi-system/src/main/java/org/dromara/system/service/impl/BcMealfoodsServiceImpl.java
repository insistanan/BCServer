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
import org.dromara.system.domain.bo.BcMealfoodsBo;
import org.dromara.system.domain.vo.BcMealfoodsVo;
import org.dromara.system.domain.BcMealfoods;
import org.dromara.system.mapper.BcMealfoodsMapper;
import org.dromara.system.service.IBcMealfoodsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 菜品Service业务层处理
 *
 * @author 周强
 * @date 2023-11-16
 */
@RequiredArgsConstructor
@Service
public class BcMealfoodsServiceImpl implements IBcMealfoodsService {

    private final BcMealfoodsMapper baseMapper;

    /**
     * 查询菜品
     */
    @Override
    public BcMealfoodsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询菜品列表
     */
    @Override
    public TableDataInfo<BcMealfoodsVo> queryPageList(BcMealfoodsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealfoods> lqw = buildQueryWrapper(bo);
        Page<BcMealfoodsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询菜品列表
     */
    @Override
    public List<BcMealfoodsVo> queryList(BcMealfoodsBo bo) {
        LambdaQueryWrapper<BcMealfoods> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealfoods> buildQueryWrapper(BcMealfoodsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealfoods> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getFoodName()), BcMealfoods::getFoodName, bo.getFoodName());
        lqw.eq(bo.getFoodPrice() != null, BcMealfoods::getFoodPrice, bo.getFoodPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getFoodGrounding()), BcMealfoods::getFoodGrounding, bo.getFoodGrounding());
        lqw.eq(StringUtils.isNotBlank(bo.getFoodServerday()), BcMealfoods::getFoodServerday, bo.getFoodServerday());
        lqw.eq(bo.getFoodTypeid() != null, BcMealfoods::getFoodTypeid, bo.getFoodTypeid());
        lqw.eq(StringUtils.isNotBlank(bo.getAutoGrounding()), BcMealfoods::getAutoGrounding, bo.getAutoGrounding());
        lqw.eq(bo.getLimitNum() != null, BcMealfoods::getLimitNum, bo.getLimitNum());
        lqw.eq(StringUtils.isNotBlank(bo.getStockNum()), BcMealfoods::getStockNum, bo.getStockNum());
        lqw.eq(StringUtils.isNotBlank(bo.getFirstReduce()), BcMealfoods::getFirstReduce, bo.getFirstReduce());
        lqw.eq(StringUtils.isNotBlank(bo.getRemark()), BcMealfoods::getRemark, bo.getRemark());
        lqw.eq(StringUtils.isNotBlank(bo.getOpenType()), BcMealfoods::getOpenType, bo.getOpenType());
        lqw.eq(StringUtils.isNotBlank(bo.getEnDept()), BcMealfoods::getEnDept, bo.getEnDept());
        lqw.eq(StringUtils.isNotBlank(bo.getEnJob()), BcMealfoods::getEnJob, bo.getEnJob());
        lqw.eq(StringUtils.isNotBlank(bo.getFoodImg()), BcMealfoods::getFoodImg, bo.getFoodImg());
        return lqw;
    }

    /**
     * 新增菜品
     */
    @Override
    public Boolean insertByBo(BcMealfoodsBo bo) {
        BcMealfoods add = MapstructUtils.convert(bo, BcMealfoods.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改菜品
     */
    @Override
    public Boolean updateByBo(BcMealfoodsBo bo) {
        BcMealfoods update = MapstructUtils.convert(bo, BcMealfoods.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealfoods entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除菜品
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

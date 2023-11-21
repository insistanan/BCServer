package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcMealdailymenu;
import org.dromara.system.domain.bo.BcMealdailymenuBo;
import org.dromara.system.domain.vo.BcMealdailymenuVo;
import org.dromara.system.mapper.BcMealdailymenuMapper;
import org.dromara.system.service.IBcMealdailymenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 每日菜谱Service业务层处理
 *
 * @author 周强
 * @date 2023-11-17
 */
@RequiredArgsConstructor
@Service
public class BcMealdailymenuServiceImpl implements IBcMealdailymenuService {

    private final BcMealdailymenuMapper baseMapper;

    /**
     * 查询每日菜谱
     */
    @Override
    public BcMealdailymenuVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询每日菜谱列表
     */
    @Override
    public TableDataInfo<BcMealdailymenuVo> queryPageList(BcMealdailymenuBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealdailymenu> lqw = buildQueryWrapper(bo);
        Page<BcMealdailymenuVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.setRecords(baseMapper.selectBcMealdailymenu(bo.getFoodtypeName(), bo.getFoodGrounding()));
        return TableDataInfo.build(result);
    }

    /**
     * 查询每日菜谱列表
     */
    @Override
    public List<BcMealdailymenuVo> queryList(BcMealdailymenuBo bo) {
        LambdaQueryWrapper<BcMealdailymenu> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealdailymenu> buildQueryWrapper(BcMealdailymenuBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealdailymenu> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getFoodName()), BcMealdailymenu::getFoodName, bo.getFoodName());
        lqw.eq(bo.getFoodtypeName() != null, BcMealdailymenu::getFoodtypeName, bo.getFoodtypeName());
        lqw.eq(bo.getFoodPrice() != null, BcMealdailymenu::getFoodPrice, bo.getFoodPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getStockNum()), BcMealdailymenu::getStockNum, bo.getStockNum());
        lqw.eq(StringUtils.isNotBlank(bo.getFoodImg()), BcMealdailymenu::getFoodImg, bo.getFoodImg());
        lqw.eq(bo.getFoodGrounding() != null, BcMealdailymenu::getFoodGrounding, bo.getFoodGrounding());
        lqw.eq(bo.getSearchTime() != null, BcMealdailymenu::getSearchTime, bo.getSearchTime());
        return lqw;
    }

    /**
     * 新增每日菜谱
     */
    @Override
    public Boolean insertByBo(BcMealdailymenuBo bo) {
        BcMealdailymenu add = MapstructUtils.convert(bo, BcMealdailymenu.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改每日菜谱
     */
    @Override
    public Boolean updateByBo(BcMealdailymenuBo bo) {
        BcMealdailymenu update = MapstructUtils.convert(bo, BcMealdailymenu.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealdailymenu entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除每日菜谱
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

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
import org.dromara.system.domain.bo.BcMealfoodtypeBo;
import org.dromara.system.domain.vo.BcMealfoodtypeVo;
import org.dromara.system.domain.BcMealfoodtype;
import org.dromara.system.mapper.BcMealfoodtypeMapper;
import org.dromara.system.service.IBcMealfoodtypeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 菜品类型Service业务层处理
 *
 * @author 周强
 * @date 2023-11-16
 */
@RequiredArgsConstructor
@Service
public class BcMealfoodtypeServiceImpl implements IBcMealfoodtypeService {

    private final BcMealfoodtypeMapper baseMapper;

    /**
     * 查询菜品类型
     */
    @Override
    public BcMealfoodtypeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询菜品类型列表
     */
    @Override
    public TableDataInfo<BcMealfoodtypeVo> queryPageList(BcMealfoodtypeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealfoodtype> lqw = buildQueryWrapper(bo);
        Page<BcMealfoodtypeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询菜品类型列表
     */
    @Override
    public List<BcMealfoodtypeVo> queryList(BcMealfoodtypeBo bo) {
        LambdaQueryWrapper<BcMealfoodtype> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealfoodtype> buildQueryWrapper(BcMealfoodtypeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealfoodtype> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getFoodtypeName()), BcMealfoodtype::getFoodtypeName, bo.getFoodtypeName());
        return lqw;
    }

    /**
     * 新增菜品类型
     */
    @Override
    public Boolean insertByBo(BcMealfoodtypeBo bo) {
        BcMealfoodtype add = MapstructUtils.convert(bo, BcMealfoodtype.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改菜品类型
     */
    @Override
    public Boolean updateByBo(BcMealfoodtypeBo bo) {
        BcMealfoodtype update = MapstructUtils.convert(bo, BcMealfoodtype.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealfoodtype entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除菜品类型
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

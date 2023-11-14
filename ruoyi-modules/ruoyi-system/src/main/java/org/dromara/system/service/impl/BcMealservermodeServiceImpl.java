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
import org.dromara.system.domain.bo.BcMealservermodeBo;
import org.dromara.system.domain.vo.BcMealservermodeVo;
import org.dromara.system.domain.BcMealservermode;
import org.dromara.system.mapper.BcMealservermodeMapper;
import org.dromara.system.service.IBcMealservermodeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 开餐模式信息Service业务层处理
 *
 * @author 周强
 * @date 2023-11-14
 */
@RequiredArgsConstructor
@Service
public class BcMealservermodeServiceImpl implements IBcMealservermodeService {

    private final BcMealservermodeMapper baseMapper;

    /**
     * 查询开餐模式信息
     */
    @Override
    public BcMealservermodeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询开餐模式信息列表
     */
    @Override
    public TableDataInfo<BcMealservermodeVo> queryPageList(BcMealservermodeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealservermode> lqw = buildQueryWrapper(bo);
        Page<BcMealservermodeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询开餐模式信息列表
     */
    @Override
    public List<BcMealservermodeVo> queryList(BcMealservermodeBo bo) {
        LambdaQueryWrapper<BcMealservermode> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealservermode> buildQueryWrapper(BcMealservermodeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealservermode> lqw = Wrappers.lambdaQuery();
        return lqw;
    }

    /**
     * 新增开餐模式信息
     */
    @Override
    public Boolean insertByBo(BcMealservermodeBo bo) {
        BcMealservermode add = MapstructUtils.convert(bo, BcMealservermode.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改开餐模式信息
     */
    @Override
    public Boolean updateByBo(BcMealservermodeBo bo) {
        BcMealservermode update = MapstructUtils.convert(bo, BcMealservermode.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealservermode entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除开餐模式信息
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

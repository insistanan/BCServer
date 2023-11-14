package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcMealforbidday;
import org.dromara.system.domain.bo.BcMealforbiddayBo;
import org.dromara.system.domain.vo.BcMealforbiddayVo;
import org.dromara.system.mapper.BcMealforbiddayMapper;
import org.dromara.system.service.IBcMealforbiddayService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 禁止用餐日期Service业务层处理
 *
 * @author 周强
 * @date 2023-11-14
 */
@RequiredArgsConstructor
@Service
public class BcMealforbiddayServiceImpl implements IBcMealforbiddayService {

    private final BcMealforbiddayMapper baseMapper;

    /**
     * 查询禁止用餐日期
     */
    @Override
    public BcMealforbiddayVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询禁止用餐日期列表
     */
    @Override
    public TableDataInfo<BcMealforbiddayVo> queryPageList(BcMealforbiddayBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealforbidday> lqw = buildQueryWrapper(bo);
        Page<BcMealforbiddayVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询禁止用餐日期列表
     */
    @Override
    public List<BcMealforbiddayVo> queryList(BcMealforbiddayBo bo) {
        LambdaQueryWrapper<BcMealforbidday> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealforbidday> buildQueryWrapper(BcMealforbiddayBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealforbidday> lqw = Wrappers.lambdaQuery();
        return lqw;
    }

    /**
     * 新增禁止用餐日期
     */
    @Override
    public Boolean insertByBo(BcMealforbiddayBo bo) {
        BcMealforbidday add = MapstructUtils.convert(bo, BcMealforbidday.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改禁止用餐日期
     */
    @Override
    public Boolean updateByBo(BcMealforbiddayBo bo) {
        BcMealforbidday update = MapstructUtils.convert(bo, BcMealforbidday.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealforbidday entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除禁止用餐日期
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

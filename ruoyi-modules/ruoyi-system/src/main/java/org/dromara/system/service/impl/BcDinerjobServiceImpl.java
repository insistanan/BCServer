package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcDinerjob;
import org.dromara.system.domain.bo.BcDinerjobBo;
import org.dromara.system.domain.vo.BcDinerjobVo;
import org.dromara.system.mapper.BcDinerjobMapper;
import org.dromara.system.service.IBcDinerjobService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 职务设置Service业务层处理
 *
 * @author 周强
 * @date 2023-11-13
 */
@RequiredArgsConstructor
@Service
public class BcDinerjobServiceImpl implements IBcDinerjobService {

    private final BcDinerjobMapper baseMapper;

    /**
     * 查询职务设置
     */
    @Override
    public BcDinerjobVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询职务设置列表
     */
    @Override
    public TableDataInfo<BcDinerjobVo> queryPageList(BcDinerjobBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcDinerjob> lqw = buildQueryWrapper(bo);
        Page<BcDinerjobVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询职务设置列表
     */
    @Override
    public List<BcDinerjobVo> queryList(BcDinerjobBo bo) {
        LambdaQueryWrapper<BcDinerjob> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcDinerjob> buildQueryWrapper(BcDinerjobBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcDinerjob> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getJobName()), BcDinerjob::getJobName, bo.getJobName());
        return lqw;
    }

    /**
     * 新增职务设置
     */
    @Override
    public Boolean insertByBo(BcDinerjobBo bo) {
        BcDinerjob add = MapstructUtils.convert(bo, BcDinerjob.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改职务设置
     */
    @Override
    public Boolean updateByBo(BcDinerjobBo bo) {
        BcDinerjob update = MapstructUtils.convert(bo, BcDinerjob.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcDinerjob entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除职务设置
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

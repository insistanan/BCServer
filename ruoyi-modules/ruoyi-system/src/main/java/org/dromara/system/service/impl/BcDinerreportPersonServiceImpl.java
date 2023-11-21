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
import org.dromara.system.domain.bo.BcDinerreportPersonBo;
import org.dromara.system.domain.vo.BcDinerreportPersonVo;
import org.dromara.system.domain.BcDinerreportPerson;
import org.dromara.system.mapper.BcDinerreportPersonMapper;
import org.dromara.system.service.IBcDinerreportPersonService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 未实际就餐统计Service业务层处理
 *
 * @author 周强
 * @date 2023-11-21
 */
@RequiredArgsConstructor
@Service
public class BcDinerreportPersonServiceImpl implements IBcDinerreportPersonService {

    private final BcDinerreportPersonMapper baseMapper;

    /**
     * 查询未实际就餐统计
     */
    @Override
    public BcDinerreportPersonVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询未实际就餐统计列表
     */
    @Override
    public TableDataInfo<BcDinerreportPersonVo> queryPageList(BcDinerreportPersonBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcDinerreportPerson> lqw = buildQueryWrapper(bo);
        Page<BcDinerreportPersonVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询未实际就餐统计列表
     */
    @Override
    public List<BcDinerreportPersonVo> queryList(BcDinerreportPersonBo bo) {
        LambdaQueryWrapper<BcDinerreportPerson> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcDinerreportPerson> buildQueryWrapper(BcDinerreportPersonBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcDinerreportPerson> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getCustomerName()), BcDinerreportPerson::getCustomerName, bo.getCustomerName());
        lqw.like(StringUtils.isNotBlank(bo.getDeptName()), BcDinerreportPerson::getDeptName, bo.getDeptName());
        lqw.like(StringUtils.isNotBlank(bo.getJobName()), BcDinerreportPerson::getJobName, bo.getJobName());
        lqw.like(StringUtils.isNotBlank(bo.getServetimeName()), BcDinerreportPerson::getServetimeName, bo.getServetimeName());
        lqw.eq(bo.getUnusenum() != null, BcDinerreportPerson::getUnusenum, bo.getUnusenum());
        lqw.eq(bo.getSingleunusenum() != null, BcDinerreportPerson::getSingleunusenum, bo.getSingleunusenum());
        return lqw;
    }

    /**
     * 新增未实际就餐统计
     */
    @Override
    public Boolean insertByBo(BcDinerreportPersonBo bo) {
        BcDinerreportPerson add = MapstructUtils.convert(bo, BcDinerreportPerson.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改未实际就餐统计
     */
    @Override
    public Boolean updateByBo(BcDinerreportPersonBo bo) {
        BcDinerreportPerson update = MapstructUtils.convert(bo, BcDinerreportPerson.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcDinerreportPerson entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除未实际就餐统计
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

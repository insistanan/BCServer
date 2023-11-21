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
import org.dromara.system.domain.bo.BcMealdetailBo;
import org.dromara.system.domain.vo.BcMealdetailVo;
import org.dromara.system.domain.BcMealdetail;
import org.dromara.system.mapper.BcMealdetailMapper;
import org.dromara.system.service.IBcMealdetailService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 报餐明细Service业务层处理
 *
 * @author anan
 * @date 2023-11-17
 */
@RequiredArgsConstructor
@Service
public class BcMealdetailServiceImpl implements IBcMealdetailService {

    private final BcMealdetailMapper baseMapper;

    /**
     * 查询报餐明细
     */
    @Override
    public BcMealdetailVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询报餐明细列表
     */
    @Override
    public TableDataInfo<BcMealdetailVo> queryPageList(BcMealdetailBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealdetail> lqw = buildQueryWrapper(bo);
        Page<BcMealdetailVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询报餐明细列表
     */
    @Override
    public List<BcMealdetailVo> queryList(BcMealdetailBo bo) {
        LambdaQueryWrapper<BcMealdetail> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealdetail> buildQueryWrapper(BcMealdetailBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealdetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getFoodGrounding() != null, BcMealdetail::getFoodGrounding, bo.getFoodGrounding());
        lqw.eq(bo.getDeptId() != null, BcMealdetail::getDeptId, bo.getDeptId());
        lqw.eq(bo.getJobId() != null, BcMealdetail::getJobId, bo.getJobId());
        lqw.eq(bo.getFoodTypeid() != null, BcMealdetail::getFoodTypeid, bo.getFoodTypeid());
        lqw.eq(bo.getOrderId() != null, BcMealdetail::getOrderId, bo.getOrderId());
        lqw.eq(bo.getSumPrice() != null, BcMealdetail::getSumPrice, bo.getSumPrice());
        lqw.like(StringUtils.isNotBlank(bo.getCustomerName()), BcMealdetail::getCustomerName, bo.getCustomerName());
        lqw.eq(StringUtils.isNotBlank(bo.getCustomerPhone()), BcMealdetail::getCustomerPhone, bo.getCustomerPhone());
        lqw.eq(bo.getDinnerTime() != null, BcMealdetail::getDinnerTime, bo.getDinnerTime());
        lqw.eq(StringUtils.isNotBlank(bo.getDinnerStatus()), BcMealdetail::getDinnerStatus, bo.getDinnerStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthType()), BcMealdetail::getAuthType, bo.getAuthType());
        lqw.eq(bo.getBcTime() != null, BcMealdetail::getBcTime, bo.getBcTime());
        lqw.eq(StringUtils.isNotBlank(bo.getVerificationTime()), BcMealdetail::getVerificationTime, bo.getVerificationTime());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), BcMealdetail::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增报餐明细
     */
    @Override
    public Boolean insertByBo(BcMealdetailBo bo) {
        BcMealdetail add = MapstructUtils.convert(bo, BcMealdetail.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改报餐明细
     */
    @Override
    public Boolean updateByBo(BcMealdetailBo bo) {
        BcMealdetail update = MapstructUtils.convert(bo, BcMealdetail.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealdetail entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除报餐明细
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcOrderdetailBo;
import org.dromara.system.domain.vo.BcOrderdetail;
import org.dromara.system.domain.vo.BcOrderdetailVo;
import org.dromara.system.mapper.BcOrderdetailMapper;
import org.dromara.system.service.IBcOrderdetailService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 订单明细Service业务层处理
 *
 * @author 周强
 * @date 2023-11-26
 */
@RequiredArgsConstructor
@Service
public class BcOrderdetailServiceImpl implements IBcOrderdetailService {

    private final BcOrderdetailMapper baseMapper;

    /**
     * 查询订单明细
     */
    @Override
    public BcOrderdetailVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询订单明细列表
     */
    @Override
    public TableDataInfo<BcOrderdetailVo> queryPageList(BcOrderdetailBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcOrderdetail> lqw = buildQueryWrapper(bo);
        Page<BcOrderdetailVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询订单明细列表
     */
    @Override
    public List<BcOrderdetailVo> queryList(BcOrderdetailBo bo) {
        LambdaQueryWrapper<BcOrderdetail> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcOrderdetail> buildQueryWrapper(BcOrderdetailBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcOrderdetail> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getDetailId() != null, BcOrderdetail::getDetailId, bo.getDetailId());
        lqw.eq(bo.getFoodGrounding() != null, BcOrderdetail::getFoodGrounding, bo.getFoodGrounding());
        lqw.eq(bo.getFoodId() != null, BcOrderdetail::getFoodId, bo.getFoodId());
        lqw.eq(bo.getFoodNumber() != null, BcOrderdetail::getFoodNumber, bo.getFoodNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), BcOrderdetail::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增订单明细
     */
    @Override
    public Boolean insertByBo(BcOrderdetailBo bo) {
        BcOrderdetail add = MapstructUtils.convert(bo, BcOrderdetail.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改订单明细
     */
    @Override
    public Boolean updateByBo(BcOrderdetailBo bo) {
        BcOrderdetail update = MapstructUtils.convert(bo, BcOrderdetail.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcOrderdetail entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除订单明细
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

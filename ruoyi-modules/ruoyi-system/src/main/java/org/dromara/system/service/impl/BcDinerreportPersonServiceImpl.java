package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcDinerreportPerson;
import org.dromara.system.domain.bo.BcDinerreportPersonBo;
import org.dromara.system.domain.vo.BcDinerreportPersonVo;
import org.dromara.system.mapper.BcDinerreportPersonMapper;
import org.dromara.system.service.IBcDinerreportPersonService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        return lqw;
    }

    /**
     * 新增未实际就餐统计
     */
    @Override
    public Boolean insertByBo(BcDinerreportPersonBo bo) {
        return true;
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

    @Override
    public List<BcDinerreportPersonVo> queryDinerreportPerson(BcDinerreportPersonBo bo) {
        return baseMapper.queryDinerreportPerson(DateUtils.parseDate(bo.getBegindate()), DateUtils.parseDate(bo.getEnddate()));
    }
}

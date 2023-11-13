package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcDinernoreview;
import org.dromara.system.domain.bo.BcDinernoreviewBo;
import org.dromara.system.domain.vo.BcDinernoreviewVo;
import org.dromara.system.mapper.BcDinernoreviewMapper;
import org.dromara.system.service.IBcDinernoreviewService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 免审核人员Service业务层处理
 *
 * @author 周强
 * @date 2023-11-13
 */
@RequiredArgsConstructor
@Service
public class BcDinernoreviewServiceImpl implements IBcDinernoreviewService {

    private final BcDinernoreviewMapper baseMapper;

    /**
     * 查询免审核人员
     */
    @Override
    public BcDinernoreviewVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询免审核人员列表
     */
    @Override
    public TableDataInfo<BcDinernoreviewVo> queryPageList(BcDinernoreviewBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcDinernoreview> lqw = buildQueryWrapper(bo);
        Page<BcDinernoreviewVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询免审核人员列表
     */
    @Override
    public List<BcDinernoreviewVo> queryList(BcDinernoreviewBo bo) {
        LambdaQueryWrapper<BcDinernoreview> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcDinernoreview> buildQueryWrapper(BcDinernoreviewBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcDinernoreview> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getPersonName()), BcDinernoreview::getPersonName, bo.getPersonName());
        lqw.eq(StringUtils.isNotBlank(bo.getPersonTel()), BcDinernoreview::getPersonTel, bo.getPersonTel());
        lqw.eq(bo.getPersonDinerdeptid() != null, BcDinernoreview::getPersonDinerdeptid, bo.getPersonDinerdeptid());
        lqw.eq(bo.getPersonDinerjobid() != null, BcDinernoreview::getPersonDinerjobid, bo.getPersonDinerjobid());
        return lqw;
    }

    /**
     * 新增免审核人员
     */
    @Override
    public Boolean insertByBo(BcDinernoreviewBo bo) {
        BcDinernoreview add = MapstructUtils.convert(bo, BcDinernoreview.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改免审核人员
     */
    @Override
    public Boolean updateByBo(BcDinernoreviewBo bo) {
        BcDinernoreview update = MapstructUtils.convert(bo, BcDinernoreview.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcDinernoreview entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除免审核人员
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

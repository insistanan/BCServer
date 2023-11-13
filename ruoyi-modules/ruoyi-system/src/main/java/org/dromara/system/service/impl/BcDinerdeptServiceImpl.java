package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcDinerdept;
import org.dromara.system.domain.bo.BcDinerdeptBo;
import org.dromara.system.domain.vo.BcDinerdeptVo;
import org.dromara.system.mapper.BcDinerdeptMapper;
import org.dromara.system.service.IBcDinerdeptService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 用餐人员部门Service业务层处理
 *
 * @author 周强
 * @date 2023-11-13
 */
@RequiredArgsConstructor
@Service
public class BcDinerdeptServiceImpl implements IBcDinerdeptService {

    private final BcDinerdeptMapper baseMapper;

    /**
     * 查询用餐人员部门
     */
    @Override
    public BcDinerdeptVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询用餐人员部门列表
     */
    @Override
    public TableDataInfo<BcDinerdeptVo> queryPageList(BcDinerdeptBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcDinerdept> lqw = buildQueryWrapper(bo);
        Page<BcDinerdeptVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询用餐人员部门列表
     */
    @Override
    public List<BcDinerdeptVo> queryList(BcDinerdeptBo bo) {
        LambdaQueryWrapper<BcDinerdept> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcDinerdept> buildQueryWrapper(BcDinerdeptBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcDinerdept> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getDeptName()), BcDinerdept::getDeptName, bo.getDeptName());
        lqw.eq(bo.getOrderNum() != null, BcDinerdept::getOrderNum, bo.getOrderNum());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), BcDinerdept::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增用餐人员部门
     */
    @Override
    public Boolean insertByBo(BcDinerdeptBo bo) {
        BcDinerdept add = MapstructUtils.convert(bo, BcDinerdept.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改用餐人员部门
     */
    @Override
    public Boolean updateByBo(BcDinerdeptBo bo) {
        BcDinerdept update = MapstructUtils.convert(bo, BcDinerdept.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcDinerdept entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除用餐人员部门
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

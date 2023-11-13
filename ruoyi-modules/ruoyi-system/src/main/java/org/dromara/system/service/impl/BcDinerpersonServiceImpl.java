package org.dromara.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.BcDinerperson;
import org.dromara.system.domain.bo.BcDinerpersonBo;
import org.dromara.system.domain.vo.BcDinerpersonVo;
import org.dromara.system.mapper.BcDinerpersonMapper;
import org.dromara.system.service.IBcDinerpersonService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 用餐人员信息Service业务层处理
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@RequiredArgsConstructor
@Service
public class BcDinerpersonServiceImpl implements IBcDinerpersonService {

    private final BcDinerpersonMapper baseMapper;

    /**
     * 查询用餐人员信息
     */
    @Override
    public BcDinerpersonVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询用餐人员信息列表
     */
    @Override
    public TableDataInfo<BcDinerpersonVo> queryPageList(BcDinerpersonBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcDinerperson> lqw = buildQueryWrapper(bo);
        Page<BcDinerpersonVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询用餐人员信息列表
     */
    @Override
    public List<BcDinerpersonVo> queryList(BcDinerpersonBo bo) {
        LambdaQueryWrapper<BcDinerperson> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcDinerperson> buildQueryWrapper(BcDinerpersonBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcDinerperson> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getPersonCode()), BcDinerperson::getPersonCode, bo.getPersonCode());
        lqw.like(StringUtils.isNotBlank(bo.getPersonName()), BcDinerperson::getPersonName, bo.getPersonName());
        lqw.eq(StringUtils.isNotBlank(bo.getPersonTel()), BcDinerperson::getPersonTel, bo.getPersonTel());
        lqw.eq(StringUtils.isNotBlank(bo.getPersonCardno()), BcDinerperson::getPersonCardno, bo.getPersonCardno());
        lqw.eq(bo.getPersonDinerdeptid() != null, BcDinerperson::getPersonDinerdeptid, bo.getPersonDinerdeptid());
        lqw.eq(bo.getPersonDinerjobid() != null, BcDinerperson::getPersonDinerjobid, bo.getPersonDinerjobid());
        lqw.eq(bo.getPersonHeadimg() != null, BcDinerperson::getPersonHeadimg, bo.getPersonHeadimg());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), BcDinerperson::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增用餐人员信息
     */
    @Override
    public Boolean insertByBo(BcDinerpersonBo bo) {
        BcDinerperson add = MapstructUtils.convert(bo, BcDinerperson.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改用餐人员信息
     */
    @Override
    public Boolean updateByBo(BcDinerpersonBo bo) {
        BcDinerperson update = MapstructUtils.convert(bo, BcDinerperson.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcDinerperson entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除用餐人员信息
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

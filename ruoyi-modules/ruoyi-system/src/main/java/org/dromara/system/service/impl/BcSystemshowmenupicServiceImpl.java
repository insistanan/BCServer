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
import org.dromara.system.domain.bo.BcSystemshowmenupicBo;
import org.dromara.system.domain.vo.BcSystemshowmenupicVo;
import org.dromara.system.domain.BcSystemshowmenupic;
import org.dromara.system.mapper.BcSystemshowmenupicMapper;
import org.dromara.system.service.IBcSystemshowmenupicService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 菜谱图片Service业务层处理
 *
 * @author 周强
 * @date 2023-11-19
 */
@RequiredArgsConstructor
@Service
public class BcSystemshowmenupicServiceImpl implements IBcSystemshowmenupicService {

    private final BcSystemshowmenupicMapper baseMapper;

    /**
     * 查询菜谱图片
     */
    @Override
    public BcSystemshowmenupicVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询菜谱图片列表
     */
    @Override
    public TableDataInfo<BcSystemshowmenupicVo> queryPageList(BcSystemshowmenupicBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcSystemshowmenupic> lqw = buildQueryWrapper(bo);
        Page<BcSystemshowmenupicVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询菜谱图片列表
     */
    @Override
    public List<BcSystemshowmenupicVo> queryList(BcSystemshowmenupicBo bo) {
        LambdaQueryWrapper<BcSystemshowmenupic> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcSystemshowmenupic> buildQueryWrapper(BcSystemshowmenupicBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcSystemshowmenupic> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getPath()), BcSystemshowmenupic::getPath, bo.getPath());
        return lqw;
    }

    /**
     * 新增菜谱图片
     */
    @Override
    public Boolean insertByBo(BcSystemshowmenupicBo bo) {
        BcSystemshowmenupic add = MapstructUtils.convert(bo, BcSystemshowmenupic.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改菜谱图片
     */
    @Override
    public Boolean updateByBo(BcSystemshowmenupicBo bo) {
        BcSystemshowmenupic update = MapstructUtils.convert(bo, BcSystemshowmenupic.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcSystemshowmenupic entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除菜谱图片
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

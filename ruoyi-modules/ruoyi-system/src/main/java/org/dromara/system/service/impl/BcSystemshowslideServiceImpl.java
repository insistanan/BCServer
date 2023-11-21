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
import org.dromara.system.domain.bo.BcSystemshowslideBo;
import org.dromara.system.domain.vo.BcSystemshowslideVo;
import org.dromara.system.domain.BcSystemshowslide;
import org.dromara.system.mapper.BcSystemshowslideMapper;
import org.dromara.system.service.IBcSystemshowslideService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 首页幻灯片Service业务层处理
 *
 * @author 周强
 * @date 2023-11-19
 */
@RequiredArgsConstructor
@Service
public class BcSystemshowslideServiceImpl implements IBcSystemshowslideService {

    private final BcSystemshowslideMapper baseMapper;

    /**
     * 查询首页幻灯片
     */
    @Override
    public BcSystemshowslideVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询首页幻灯片列表
     */
    @Override
    public TableDataInfo<BcSystemshowslideVo> queryPageList(BcSystemshowslideBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcSystemshowslide> lqw = buildQueryWrapper(bo);
        Page<BcSystemshowslideVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询首页幻灯片列表
     */
    @Override
    public List<BcSystemshowslideVo> queryList(BcSystemshowslideBo bo) {
        LambdaQueryWrapper<BcSystemshowslide> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcSystemshowslide> buildQueryWrapper(BcSystemshowslideBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcSystemshowslide> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), BcSystemshowslide::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getPath()), BcSystemshowslide::getPath, bo.getPath());
        lqw.eq(bo.getSort() != null, BcSystemshowslide::getSort, bo.getSort());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), BcSystemshowslide::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增首页幻灯片
     */
    @Override
    public Boolean insertByBo(BcSystemshowslideBo bo) {
        BcSystemshowslide add = MapstructUtils.convert(bo, BcSystemshowslide.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改首页幻灯片
     */
    @Override
    public Boolean updateByBo(BcSystemshowslideBo bo) {
        BcSystemshowslide update = MapstructUtils.convert(bo, BcSystemshowslide.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcSystemshowslide entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除首页幻灯片
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

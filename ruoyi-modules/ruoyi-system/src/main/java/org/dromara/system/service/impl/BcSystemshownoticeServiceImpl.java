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
import org.dromara.system.domain.bo.BcSystemshownoticeBo;
import org.dromara.system.domain.vo.BcSystemshownoticeVo;
import org.dromara.system.domain.BcSystemshownotice;
import org.dromara.system.mapper.BcSystemshownoticeMapper;
import org.dromara.system.service.IBcSystemshownoticeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 公告Service业务层处理
 *
 * @author 周强
 * @date 2023-11-19
 */
@RequiredArgsConstructor
@Service
public class BcSystemshownoticeServiceImpl implements IBcSystemshownoticeService {

    private final BcSystemshownoticeMapper baseMapper;

    /**
     * 查询公告
     */
    @Override
    public BcSystemshownoticeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询公告列表
     */
    @Override
    public TableDataInfo<BcSystemshownoticeVo> queryPageList(BcSystemshownoticeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcSystemshownotice> lqw = buildQueryWrapper(bo);
        Page<BcSystemshownoticeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询公告列表
     */
    @Override
    public List<BcSystemshownoticeVo> queryList(BcSystemshownoticeBo bo) {
        LambdaQueryWrapper<BcSystemshownotice> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcSystemshownotice> buildQueryWrapper(BcSystemshownoticeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcSystemshownotice> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getNoticeName()), BcSystemshownotice::getNoticeName, bo.getNoticeName());
        lqw.eq(bo.getNoticeSort() != null, BcSystemshownotice::getNoticeSort, bo.getNoticeSort());
        lqw.eq(StringUtils.isNotBlank(bo.getNoticeStatus()), BcSystemshownotice::getNoticeStatus, bo.getNoticeStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getNoticeContent()), BcSystemshownotice::getNoticeContent, bo.getNoticeContent());
        return lqw;
    }

    /**
     * 新增公告
     */
    @Override
    public Boolean insertByBo(BcSystemshownoticeBo bo) {
        BcSystemshownotice add = MapstructUtils.convert(bo, BcSystemshownotice.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改公告
     */
    @Override
    public Boolean updateByBo(BcSystemshownoticeBo bo) {
        BcSystemshownotice update = MapstructUtils.convert(bo, BcSystemshownotice.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcSystemshownotice entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除公告
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

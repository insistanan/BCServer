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
import org.dromara.system.domain.bo.BcMealcommentBo;
import org.dromara.system.domain.vo.BcMealcommentVo;
import org.dromara.system.domain.BcMealcomment;
import org.dromara.system.mapper.BcMealcommentMapper;
import org.dromara.system.service.IBcMealcommentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 评论Service业务层处理
 *
 * @author 周强
 * @date 2023-11-16
 */
@RequiredArgsConstructor
@Service
public class BcMealcommentServiceImpl implements IBcMealcommentService {

    private final BcMealcommentMapper baseMapper;

    /**
     * 查询评论
     */
    @Override
    public BcMealcommentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询评论列表
     */
    @Override
    public TableDataInfo<BcMealcommentVo> queryPageList(BcMealcommentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealcomment> lqw = buildQueryWrapper(bo);
        Page<BcMealcommentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询评论列表
     */
    @Override
    public List<BcMealcommentVo> queryList(BcMealcommentBo bo) {
        LambdaQueryWrapper<BcMealcomment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealcomment> buildQueryWrapper(BcMealcommentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealcomment> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getComment()), BcMealcomment::getComment, bo.getComment());
        lqw.eq(bo.getScore() != null, BcMealcomment::getScore, bo.getScore());
        lqw.eq(StringUtils.isNotBlank(bo.getFoodGrounding()), BcMealcomment::getFoodGrounding, bo.getFoodGrounding());
        lqw.like(StringUtils.isNotBlank(bo.getPersonName()), BcMealcomment::getPersonName, bo.getPersonName());
        lqw.eq(bo.getPersonDinerdeptid() != null, BcMealcomment::getPersonDinerdeptid, bo.getPersonDinerdeptid());
        lqw.eq(bo.getPersonDinerjobid() != null, BcMealcomment::getPersonDinerjobid, bo.getPersonDinerjobid());
        lqw.eq(bo.getCommentTime() != null, BcMealcomment::getCommentTime, bo.getCommentTime());
        return lqw;
    }

    /**
     * 新增评论
     */
    @Override
    public Boolean insertByBo(BcMealcommentBo bo) {
        BcMealcomment add = MapstructUtils.convert(bo, BcMealcomment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改评论
     */
    @Override
    public Boolean updateByBo(BcMealcommentBo bo) {
        BcMealcomment update = MapstructUtils.convert(bo, BcMealcomment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealcomment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除评论
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

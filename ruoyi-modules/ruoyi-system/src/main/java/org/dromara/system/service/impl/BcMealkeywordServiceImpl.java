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
import org.dromara.system.domain.bo.BcMealkeywordBo;
import org.dromara.system.domain.vo.BcMealkeywordVo;
import org.dromara.system.domain.BcMealkeyword;
import org.dromara.system.mapper.BcMealkeywordMapper;
import org.dromara.system.service.IBcMealkeywordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 关键词Service业务层处理
 *
 * @author 周强
 * @date 2023-11-16
 */
@RequiredArgsConstructor
@Service
public class BcMealkeywordServiceImpl implements IBcMealkeywordService {

    private final BcMealkeywordMapper baseMapper;

    /**
     * 查询关键词
     */
    @Override
    public BcMealkeywordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询关键词列表
     */
    @Override
    public TableDataInfo<BcMealkeywordVo> queryPageList(BcMealkeywordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BcMealkeyword> lqw = buildQueryWrapper(bo);
        Page<BcMealkeywordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询关键词列表
     */
    @Override
    public List<BcMealkeywordVo> queryList(BcMealkeywordBo bo) {
        LambdaQueryWrapper<BcMealkeyword> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BcMealkeyword> buildQueryWrapper(BcMealkeywordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BcMealkeyword> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getKeywordName()), BcMealkeyword::getKeywordName, bo.getKeywordName());
        return lqw;
    }

    /**
     * 新增关键词
     */
    @Override
    public Boolean insertByBo(BcMealkeywordBo bo) {
        BcMealkeyword add = MapstructUtils.convert(bo, BcMealkeyword.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改关键词
     */
    @Override
    public Boolean updateByBo(BcMealkeywordBo bo) {
        BcMealkeyword update = MapstructUtils.convert(bo, BcMealkeyword.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BcMealkeyword entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除关键词
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

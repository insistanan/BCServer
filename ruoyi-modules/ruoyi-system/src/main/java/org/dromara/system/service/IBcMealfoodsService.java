package org.dromara.system.service;

import org.dromara.system.domain.BcMealfoods;
import org.dromara.system.domain.vo.BcMealfoodsVo;
import org.dromara.system.domain.bo.BcMealfoodsBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 菜品Service接口
 *
 * @author 周强
 * @date 2023-11-16
 */
public interface IBcMealfoodsService {

    /**
     * 查询菜品
     */
    BcMealfoodsVo queryById(Long id);

    /**
     * 查询菜品列表
     */
    TableDataInfo<BcMealfoodsVo> queryPageList(BcMealfoodsBo bo, PageQuery pageQuery);

    /**
     * 查询菜品列表
     */
    List<BcMealfoodsVo> queryList(BcMealfoodsBo bo);

    /**
     * 新增菜品
     */
    Boolean insertByBo(BcMealfoodsBo bo);

    /**
     * 修改菜品
     */
    Boolean updateByBo(BcMealfoodsBo bo);

    /**
     * 校验并批量删除菜品信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

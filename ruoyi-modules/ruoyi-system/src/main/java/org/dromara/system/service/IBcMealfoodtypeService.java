package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcMealfoodtypeBo;
import org.dromara.system.domain.vo.BcMealfoodtypeVo;

import java.util.Collection;
import java.util.List;

/**
 * 菜品类型Service接口
 *
 * @author 周强
 * @date 2023-11-16
 */
public interface IBcMealfoodtypeService {

    /**
     * 查询菜品类型
     */
    BcMealfoodtypeVo queryById(Long id);

    /**
     * 查询菜品类型列表
     */
    TableDataInfo<BcMealfoodtypeVo> queryPageList(BcMealfoodtypeBo bo, PageQuery pageQuery);

    /**
     * 查询菜品类型列表
     */
    List<BcMealfoodtypeVo> queryList(BcMealfoodtypeBo bo);

    /**
     * 新增菜品类型
     */
    Boolean insertByBo(BcMealfoodtypeBo bo);

    /**
     * 修改菜品类型
     */
    Boolean updateByBo(BcMealfoodtypeBo bo);

    /**
     * 校验并批量删除菜品类型信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

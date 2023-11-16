package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcMealservetimeBo;
import org.dromara.system.domain.vo.BcMealservetimeVo;

import java.util.Collection;
import java.util.List;

/**
 * 用餐时段Service接口
 *
 * @author 周强
 * @date 2023-11-16
 */
public interface IBcMealservetimeService {

    /**
     * 查询用餐时段
     */
    BcMealservetimeVo queryById(Long id);

    /**
     * 查询用餐时段列表
     */
    TableDataInfo<BcMealservetimeVo> queryPageList(BcMealservetimeBo bo, PageQuery pageQuery);

    /**
     * 查询用餐时段列表
     */
    List<BcMealservetimeVo> queryList(BcMealservetimeBo bo);

    /**
     * 新增用餐时段
     */
    Boolean insertByBo(BcMealservetimeBo bo);

    /**
     * 修改用餐时段
     */
    Boolean updateByBo(BcMealservetimeBo bo);

    /**
     * 校验并批量删除用餐时段信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

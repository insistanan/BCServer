package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcMealservermodeBo;
import org.dromara.system.domain.vo.BcMealservermodeVo;

import java.util.Collection;
import java.util.List;

/**
 * 开餐模式信息Service接口
 *
 * @author 周强
 * @date 2023-11-14
 */
public interface IBcMealservermodeService {

    /**
     * 查询开餐模式信息
     */
    BcMealservermodeVo queryById(Long id);

    /**
     * 查询开餐模式信息列表
     */
    TableDataInfo<BcMealservermodeVo> queryPageList(BcMealservermodeBo bo, PageQuery pageQuery);

    /**
     * 查询开餐模式信息列表
     */
    List<BcMealservermodeVo> queryList(BcMealservermodeBo bo);

    /**
     * 新增开餐模式信息
     */
    Boolean insertByBo(BcMealservermodeBo bo);

    /**
     * 修改开餐模式信息
     */
    Boolean updateByBo(BcMealservermodeBo bo);

    /**
     * 校验并批量删除开餐模式信息信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

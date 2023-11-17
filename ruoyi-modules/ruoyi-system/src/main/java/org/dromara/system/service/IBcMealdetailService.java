package org.dromara.system.service;

import org.dromara.system.domain.BcMealdetail;
import org.dromara.system.domain.vo.BcMealdetailVo;
import org.dromara.system.domain.bo.BcMealdetailBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 报餐明细Service接口
 *
 * @author anan
 * @date 2023-11-17
 */
public interface IBcMealdetailService {

    /**
     * 查询报餐明细
     */
    BcMealdetailVo queryById(Long id);

    /**
     * 查询报餐明细列表
     */
    TableDataInfo<BcMealdetailVo> queryPageList(BcMealdetailBo bo, PageQuery pageQuery);

    /**
     * 查询报餐明细列表
     */
    List<BcMealdetailVo> queryList(BcMealdetailBo bo);

    /**
     * 新增报餐明细
     */
    Boolean insertByBo(BcMealdetailBo bo);

    /**
     * 修改报餐明细
     */
    Boolean updateByBo(BcMealdetailBo bo);

    /**
     * 校验并批量删除报餐明细信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

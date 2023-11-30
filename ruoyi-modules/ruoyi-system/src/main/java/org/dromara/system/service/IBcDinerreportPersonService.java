package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcDinerreportPersonBo;
import org.dromara.system.domain.vo.BcDinerreportPersonVo;

import java.util.Collection;
import java.util.List;

/**
 * 未实际就餐统计Service接口
 *
 * @author 周强
 * @date 2023-11-21
 */
public interface IBcDinerreportPersonService {

    /**
     * 查询未实际就餐统计
     */
    BcDinerreportPersonVo queryById(Long id);

    /**
     * 查询未实际就餐统计列表
     */
    TableDataInfo<BcDinerreportPersonVo> queryPageList(BcDinerreportPersonBo bo, PageQuery pageQuery);

    /**
     * 查询未实际就餐统计列表
     */
    List<BcDinerreportPersonVo> queryList(BcDinerreportPersonBo bo);

    /**
     * 新增未实际就餐统计
     */
    Boolean insertByBo(BcDinerreportPersonBo bo);

    /**
     * 修改未实际就餐统计
     */
    Boolean updateByBo(BcDinerreportPersonBo bo);

    /**
     * 校验并批量删除未实际就餐统计信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    List<BcDinerreportPersonVo> queryDinerreportPerson(BcDinerreportPersonBo bo);
}

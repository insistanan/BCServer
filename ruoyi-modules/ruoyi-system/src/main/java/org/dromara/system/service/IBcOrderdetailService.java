package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcOrderdetailBo;
import org.dromara.system.domain.vo.BcOrderdetailVo;

import java.util.Collection;
import java.util.List;

/**
 * 订单明细Service接口
 *
 * @author 周强
 * @date 2023-11-26
 */
public interface IBcOrderdetailService {

    /**
     * 查询订单明细
     */
    BcOrderdetailVo queryById(Long id);

    /**
     * 查询订单明细列表
     */
    TableDataInfo<BcOrderdetailVo> queryPageList(BcOrderdetailBo bo, PageQuery pageQuery);

    /**
     * 查询订单明细列表
     */
    List<BcOrderdetailVo> queryList(BcOrderdetailBo bo);

    /**
     * 新增订单明细
     */
    Boolean insertByBo(BcOrderdetailBo bo);

    /**
     * 修改订单明细
     */
    Boolean updateByBo(BcOrderdetailBo bo);

    /**
     * 校验并批量删除订单明细信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

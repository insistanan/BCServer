package org.dromara.system.service;


import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcDinernoreviewBo;
import org.dromara.system.domain.vo.BcDinernoreviewVo;

import java.util.Collection;
import java.util.List;

/**
 * 免审核人员Service接口
 *
 * @author 周强
 * @date 2023-11-13
 */
public interface IBcDinernoreviewService {

    /**
     * 查询免审核人员
     */
    BcDinernoreviewVo queryById(Long id);

    /**
     * 查询免审核人员列表
     */
    TableDataInfo<BcDinernoreviewVo> queryPageList(BcDinernoreviewBo bo, PageQuery pageQuery);

    /**
     * 查询免审核人员列表
     */
    List<BcDinernoreviewVo> queryList(BcDinernoreviewBo bo);

    /**
     * 新增免审核人员
     */
    Boolean insertByBo(BcDinernoreviewBo bo);

    /**
     * 修改免审核人员
     */
    Boolean updateByBo(BcDinernoreviewBo bo);

    /**
     * 校验并批量删除免审核人员信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

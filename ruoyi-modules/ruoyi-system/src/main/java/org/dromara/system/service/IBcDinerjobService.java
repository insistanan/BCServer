package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcDinerjobBo;
import org.dromara.system.domain.vo.BcDinerjobVo;

import java.util.Collection;
import java.util.List;

/**
 * 职务设置Service接口
 *
 * @author 周强
 * @date 2023-11-13
 */
public interface IBcDinerjobService {

    /**
     * 查询职务设置
     */
    BcDinerjobVo queryById(Long id);

    /**
     * 查询职务设置列表
     */
    TableDataInfo<BcDinerjobVo> queryPageList(BcDinerjobBo bo, PageQuery pageQuery);

    /**
     * 查询职务设置列表
     */
    List<BcDinerjobVo> queryList(BcDinerjobBo bo);

    /**
     * 新增职务设置
     */
    Boolean insertByBo(BcDinerjobBo bo);

    /**
     * 修改职务设置
     */
    Boolean updateByBo(BcDinerjobBo bo);

    /**
     * 校验并批量删除职务设置信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

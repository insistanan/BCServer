package org.dromara.system.service;

import org.dromara.system.domain.BcSystemshownotice;
import org.dromara.system.domain.vo.BcSystemshownoticeVo;
import org.dromara.system.domain.bo.BcSystemshownoticeBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 公告Service接口
 *
 * @author 周强
 * @date 2023-11-19
 */
public interface IBcSystemshownoticeService {

    /**
     * 查询公告
     */
    BcSystemshownoticeVo queryById(Long id);

    /**
     * 查询公告列表
     */
    TableDataInfo<BcSystemshownoticeVo> queryPageList(BcSystemshownoticeBo bo, PageQuery pageQuery);

    /**
     * 查询公告列表
     */
    List<BcSystemshownoticeVo> queryList(BcSystemshownoticeBo bo);

    /**
     * 新增公告
     */
    Boolean insertByBo(BcSystemshownoticeBo bo);

    /**
     * 修改公告
     */
    Boolean updateByBo(BcSystemshownoticeBo bo);

    /**
     * 校验并批量删除公告信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

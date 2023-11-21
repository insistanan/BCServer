package org.dromara.system.service;

import org.dromara.system.domain.BcSystemshowslide;
import org.dromara.system.domain.vo.BcSystemshowslideVo;
import org.dromara.system.domain.bo.BcSystemshowslideBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 首页幻灯片Service接口
 *
 * @author 周强
 * @date 2023-11-19
 */
public interface IBcSystemshowslideService {

    /**
     * 查询首页幻灯片
     */
    BcSystemshowslideVo queryById(Long id);

    /**
     * 查询首页幻灯片列表
     */
    TableDataInfo<BcSystemshowslideVo> queryPageList(BcSystemshowslideBo bo, PageQuery pageQuery);

    /**
     * 查询首页幻灯片列表
     */
    List<BcSystemshowslideVo> queryList(BcSystemshowslideBo bo);

    /**
     * 新增首页幻灯片
     */
    Boolean insertByBo(BcSystemshowslideBo bo);

    /**
     * 修改首页幻灯片
     */
    Boolean updateByBo(BcSystemshowslideBo bo);

    /**
     * 校验并批量删除首页幻灯片信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

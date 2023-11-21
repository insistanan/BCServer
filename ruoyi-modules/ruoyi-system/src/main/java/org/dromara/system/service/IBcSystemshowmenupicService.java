package org.dromara.system.service;

import org.dromara.system.domain.BcSystemshowmenupic;
import org.dromara.system.domain.vo.BcSystemshowmenupicVo;
import org.dromara.system.domain.bo.BcSystemshowmenupicBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 菜谱图片Service接口
 *
 * @author 周强
 * @date 2023-11-19
 */
public interface IBcSystemshowmenupicService {

    /**
     * 查询菜谱图片
     */
    BcSystemshowmenupicVo queryById(Long id);

    /**
     * 查询菜谱图片列表
     */
    TableDataInfo<BcSystemshowmenupicVo> queryPageList(BcSystemshowmenupicBo bo, PageQuery pageQuery);

    /**
     * 查询菜谱图片列表
     */
    List<BcSystemshowmenupicVo> queryList(BcSystemshowmenupicBo bo);

    /**
     * 新增菜谱图片
     */
    Boolean insertByBo(BcSystemshowmenupicBo bo);

    /**
     * 修改菜谱图片
     */
    Boolean updateByBo(BcSystemshowmenupicBo bo);

    /**
     * 校验并批量删除菜谱图片信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

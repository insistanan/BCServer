package org.dromara.system.service;

import org.dromara.system.domain.BcMealkeyword;
import org.dromara.system.domain.vo.BcMealkeywordVo;
import org.dromara.system.domain.bo.BcMealkeywordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 关键词Service接口
 *
 * @author 周强
 * @date 2023-11-16
 */
public interface IBcMealkeywordService {

    /**
     * 查询关键词
     */
    BcMealkeywordVo queryById(Long id);

    /**
     * 查询关键词列表
     */
    TableDataInfo<BcMealkeywordVo> queryPageList(BcMealkeywordBo bo, PageQuery pageQuery);

    /**
     * 查询关键词列表
     */
    List<BcMealkeywordVo> queryList(BcMealkeywordBo bo);

    /**
     * 新增关键词
     */
    Boolean insertByBo(BcMealkeywordBo bo);

    /**
     * 修改关键词
     */
    Boolean updateByBo(BcMealkeywordBo bo);

    /**
     * 校验并批量删除关键词信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

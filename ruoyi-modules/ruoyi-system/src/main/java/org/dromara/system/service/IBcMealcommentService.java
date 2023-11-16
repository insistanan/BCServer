package org.dromara.system.service;

import org.dromara.system.domain.BcMealcomment;
import org.dromara.system.domain.vo.BcMealcommentVo;
import org.dromara.system.domain.bo.BcMealcommentBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 评论Service接口
 *
 * @author 周强
 * @date 2023-11-16
 */
public interface IBcMealcommentService {

    /**
     * 查询评论
     */
    BcMealcommentVo queryById(Long id);

    /**
     * 查询评论列表
     */
    TableDataInfo<BcMealcommentVo> queryPageList(BcMealcommentBo bo, PageQuery pageQuery);

    /**
     * 查询评论列表
     */
    List<BcMealcommentVo> queryList(BcMealcommentBo bo);

    /**
     * 新增评论
     */
    Boolean insertByBo(BcMealcommentBo bo);

    /**
     * 修改评论
     */
    Boolean updateByBo(BcMealcommentBo bo);

    /**
     * 校验并批量删除评论信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

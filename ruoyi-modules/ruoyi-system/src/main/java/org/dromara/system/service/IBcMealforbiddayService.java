package org.dromara.system.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.bo.BcMealforbiddayBo;
import org.dromara.system.domain.vo.BcMealforbiddayVo;

import java.util.Collection;
import java.util.List;

/**
 * 禁止用餐日期Service接口
 *
 * @author 周强
 * @date 2023-11-14
 */
public interface IBcMealforbiddayService {

    /**
     * 查询禁止用餐日期
     */
    BcMealforbiddayVo queryById(Long id);

    /**
     * 查询禁止用餐日期列表
     */
    TableDataInfo<BcMealforbiddayVo> queryPageList(BcMealforbiddayBo bo, PageQuery pageQuery);

    /**
     * 查询禁止用餐日期列表
     */
    List<BcMealforbiddayVo> queryList(BcMealforbiddayBo bo);

    /**
     * 新增禁止用餐日期
     */
    Boolean insertByBo(BcMealforbiddayBo bo);

    /**
     * 修改禁止用餐日期
     */
    Boolean updateByBo(BcMealforbiddayBo bo);

    /**
     * 校验并批量删除禁止用餐日期信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

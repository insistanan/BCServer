package org.dromara.system.mapper;

import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.system.domain.BcMealdailymenu;
import org.dromara.system.domain.vo.BcMealdailymenuVo;

import java.util.List;

/**
 * 每日菜谱Mapper接口
 *
 * @author 周强
 * @date 2023-11-17
 */
public interface BcMealdailymenuMapper extends BaseMapperPlus<BcMealdailymenu, BcMealdailymenuVo> {

    List<BcMealdailymenuVo> selectBcMealdailymenu(Long foodtypeId, Long servetimeId);


}

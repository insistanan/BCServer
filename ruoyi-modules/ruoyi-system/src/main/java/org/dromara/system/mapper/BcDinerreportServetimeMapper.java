package org.dromara.system.mapper;

import org.dromara.system.domain.BcDinerreportServetime;
import org.dromara.system.domain.vo.BcDinerreportServetimeVo;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;

import java.util.Date;
import java.util.List;

/**
 * 时段就餐统计Mapper接口
 *
 * @author 周强
 * @date 2023-11-21
 */
public interface BcDinerreportServetimeMapper extends BaseMapperPlus<BcDinerreportServetime, BcDinerreportServetimeVo> {

    List<BcDinerreportServetimeVo> queryDinerreportServetime(Date begindate, Date enddate);
}

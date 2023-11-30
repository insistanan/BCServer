package org.dromara.system.mapper;

import org.dromara.system.domain.BcDinerreportPerson;
import org.dromara.system.domain.vo.BcDinerreportPersonVo;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;

import java.util.Date;
import java.util.List;

/**
 * 未实际就餐统计Mapper接口
 *
 * @author 周强
 * @date 2023-11-21
 */
public interface BcDinerreportPersonMapper extends BaseMapperPlus<BcDinerreportPerson, BcDinerreportPersonVo> {

    List<BcDinerreportPersonVo> queryDinerreportPerson(Date parseDate, Date parseDate1);
}

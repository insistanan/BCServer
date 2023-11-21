package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcDinerreportServetime;

/**
 * 时段就餐统计业务对象 bc_dinerreport_servetime
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcDinerreportServetime.class, reverseConvertGenerate = false)
public class BcDinerreportServetimeBo extends BaseEntity {

    /**
     * 查询起始日期
     */
    @NotBlank(message = "查询起始日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private String begindate;

    /**
     * 查询截止日期
     */
    @NotBlank(message = "查询截止日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private String enddate;


}

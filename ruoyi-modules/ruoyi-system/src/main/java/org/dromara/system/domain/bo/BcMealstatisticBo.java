package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealstatistic;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 报餐统计业务对象 bc_mealstatistic
 *
 * @author anan
 * @date 2023-11-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealstatistic.class, reverseConvertGenerate = false)
public class BcMealstatisticBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 用餐时段
     */
    @NotBlank(message = "用餐时段不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodGrounding;

    /**
     * 部门。部门id
     */
    @NotNull(message = "部门。部门id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deptId;

    /**
     * 职务。职务id
     */
    @NotNull(message = "职务。职务id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long jobId;

    /**
     * 餐品名称
     */
    @NotBlank(message = "餐品名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodName;

    /**
     * 报餐时间
     */
    @NotNull(message = "报餐时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date bcTime;


}

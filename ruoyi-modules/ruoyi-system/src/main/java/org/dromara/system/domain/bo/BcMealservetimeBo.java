package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealservetime;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 用餐时段业务对象 bc_mealservetime
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealservetime.class, reverseConvertGenerate = false)
public class BcMealservetimeBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeName;

    /**
     * 时段可报份数
     */
    @NotNull(message = "时段可报份数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long servetimeNum;

    /**
     * 状态，0-开启，1关闭
     */
    @NotBlank(message = "状态，0-开启，1关闭不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeStatus;

    /**
     * 开始时间
     */
    @NotBlank(message = "开始时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeBegin;

    /**
     * 结束时间
     */
    @NotBlank(message = "结束时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeEnd;

    /**
     * 报餐提醒状态，0-开启，1关闭
     */
    @NotBlank(message = "报餐提醒状态，0-开启，1关闭不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeRemindstatus;

    /**
     * 报餐提醒时间
     */
    @NotBlank(message = "报餐提醒时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeRemind;

    /**
     * 报餐截止天数
     */
    @NotBlank(message = "报餐截止天数不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeRepotrendday;

    /**
     * 报餐截止时间
     */
    @NotBlank(message = "报餐截止时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeRepotrendtime;


}

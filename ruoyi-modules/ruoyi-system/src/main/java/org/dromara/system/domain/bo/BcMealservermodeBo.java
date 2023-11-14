package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealservermode;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 开餐模式信息业务对象 bc_mealservermode
 *
 * @author 周强
 * @date 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealservermode.class, reverseConvertGenerate = false)
public class BcMealservermodeBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 1-自选开餐，2-每日开餐，3-周日不开餐，4-周一到周五开餐
     */
    @NotBlank(message = "1-自选开餐，2-每日开餐，3-周日不开餐，4-周一到周五开餐不能为空", groups = { AddGroup.class, EditGroup.class })
    private String serverMode;

    /**
     * 开餐时间，1-7代表周一到周日
     */
    @NotBlank(message = "开餐时间，1-7代表周一到周日不能为空", groups = { AddGroup.class, EditGroup.class })
    private String serverDay;

    /**
     * 可提前报餐天数
     */
    @NotNull(message = "可提前报餐天数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer earlyDay;


}

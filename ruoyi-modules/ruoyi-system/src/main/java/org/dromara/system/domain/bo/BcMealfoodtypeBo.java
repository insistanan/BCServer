package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealfoodtype;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 菜品类型业务对象 bc_mealfoodtype
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealfoodtype.class, reverseConvertGenerate = false)
public class BcMealfoodtypeBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 菜品类型
     */
    @NotBlank(message = "菜品类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodtypeName;


}

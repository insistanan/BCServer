package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 菜品类型对象 bc_mealfoodtype
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealfoodtype")
public class BcMealfoodtype extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 菜品类型
     */
    private String foodtypeName;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

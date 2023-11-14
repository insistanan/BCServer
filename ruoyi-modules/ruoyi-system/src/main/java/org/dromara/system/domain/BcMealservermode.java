package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 开餐模式信息对象 bc_mealservermode
 *
 * @author 周强
 * @date 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealservermode")
public class BcMealservermode extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 1-自选开餐，2-每日开餐，3-周日不开餐，4-周一到周五开餐
     */
    private String serverMode;

    /**
     * 开餐时间，1-7代表周一到周日
     */
    private String serverDay;

    /**
     * 可提前报餐天数
     */
    private Integer earlyDay;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

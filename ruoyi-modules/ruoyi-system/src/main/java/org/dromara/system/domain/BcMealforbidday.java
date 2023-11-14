package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 禁止用餐日期对象 bc_mealforbidday
 *
 * @author 周强
 * @date 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealforbidday")
public class BcMealforbidday extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 禁止用餐日期
     */
    private Date forbidDate;

    /**
     * 类型
     */
    private String forbidType;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

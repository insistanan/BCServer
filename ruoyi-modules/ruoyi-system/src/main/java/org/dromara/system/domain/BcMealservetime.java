package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 用餐时段对象 bc_mealservetime
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealservetime")
public class BcMealservetime extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 标题
     */
    private String servetimeName;

    /**
     * 时段可报份数
     */
    private Long servetimeNum;

    /**
     * 状态，0-开启，1关闭
     */
    private String servetimeStatus;

    /**
     * 开始时间
     */
    private String servetimeBegin;

    /**
     * 结束时间
     */
    private String servetimeEnd;

    /**
     * 报餐提醒状态，0-开启，1关闭
     */
    private String servetimeRemindstatus;

    /**
     * 报餐提醒时间
     */
    private String servetimeRemind;

    /**
     * 报餐截止天数
     */
    private String servetimeRepotrendday;

    /**
     * 报餐截止时间
     */
    private String servetimeRepotrendtime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

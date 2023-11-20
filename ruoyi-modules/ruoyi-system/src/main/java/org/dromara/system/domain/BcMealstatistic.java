package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 报餐统计对象 bc_mealstatistic
 *
 * @author anan
 * @date 2023-11-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealstatistic")
public class BcMealstatistic extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用餐时段
     */
    private String foodGrounding;

    /**
     * 部门。部门id
     */
    private Long deptId;

    /**
     * 职务。职务id
     */
    private Long jobId;

    /**
     * 餐品名称
     */
    private String foodName;

    /**
     * 用餐状态(0待用餐，1已用餐，2退款，3其他)
     */
    private String dinnerStatus;

    /**
     * 报餐时间
     */
    private Date bcTime;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

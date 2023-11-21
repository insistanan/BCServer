package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 时段就餐统计对象 bc_dinerreport_servetime
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_dinerreport_servetime")
public class BcDinerreportServetime extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 部门
     */
    private String deptName;

    /**
     * 用餐时段
     */
    private String servetimeName;

    /**
     * 已报餐数
     */
    private Integer dinertotalnum;

    /**
     * 实际就餐数
     */
    private Integer usedinernum;

    /**
     * 未实际就餐数
     */
    private Integer unusedinernum;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

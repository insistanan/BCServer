package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 未实际就餐统计对象 bc_dinerreport_person
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_dinerreport_person")
public class BcDinerreportPerson extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 部门
     */
    private String deptName;

    /**
     * 职务
     */
    private String jobName;

    /**
     * 用餐时段
     */
    private String servetimeName;

    /**
     * 未实际就餐数
     */
    private Integer unusenum;

    /**
     * 时段未实际就餐数
     */
    private Integer singleunusenum;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

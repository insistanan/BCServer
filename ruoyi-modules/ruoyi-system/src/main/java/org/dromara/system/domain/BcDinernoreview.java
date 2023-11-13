package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 免审核人员对象 bc_dinernoreview
 *
 * @author 周强
 * @date 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_dinernoreview")
public class BcDinernoreview extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 部门名称
     */
    private String personName;

    /**
     * 手机号
     */
    private String personTel;

    /**
     * 部门
     */
    private Long personDinerdeptid;

    /**
     * 职务
     */
    private Long personDinerjobid;

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

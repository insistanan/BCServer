package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 用餐人员信息对象 bc_dinerperson
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_dinerperson")
public class BcDinerperson extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 所属餐厅
     */
    private String personCanteen;

    /**
     * 工号
     */
    private String personCode;

    /**
     * 昵称
     */
    private String personName;

    /**
     * 手机号
     */
    private String personTel;

    /**
     * 职工卡号
     */
    private String personCardno;

    /**
     * 部门
     */
    private Long personDinerdeptid;

    /**
     * 职务
     */
    private Long personDinerjobid;

    /**
     * 头像
     */
    private Long personHeadimg;

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

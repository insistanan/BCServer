package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcMealdetail;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 报餐明细业务对象 bc_mealdetail
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealdetail.class, reverseConvertGenerate = false)
public class BcMealdetailBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 用餐时段
     */
    @NotNull(message = "用餐时段不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodGrounding;

    /**
     * 部门。部门id
     */
    @NotNull(message = "部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deptId;

    /**
     * 职务。职务id
     */
    @NotNull(message = "职务不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long jobId;

    /**
     * 用餐类型
     */
    @NotNull(message = "用餐类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodTypeid;

    /**
     * 订单明细
     */
    @NotNull(message = "订单明细不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal sumPrice;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long personId;

    /**
     * 订餐人姓名
     */
    @NotBlank(message = "订餐人姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String customerName;

    /**
     * 订餐人联系电话
     */
    @NotBlank(message = "订餐人联系电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String customerPhone;

    /**
     * 用餐日期
     */
    @NotNull(message = "用餐日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date dinnerTime;

    /**
     * 用餐状态(0待用餐，1已用餐，2退款，3其他)
     */
    private String dinnerStatus;

    /**
     * 验证方式
     */
    private String authType;

    /**
     * 报餐时间
     */
    private Date bcTime;

    /**
     * 核销时间
     */
    private Date verificationTime;

    /**
     * 状态（0正常 1停用）
     */
    private String status;


}

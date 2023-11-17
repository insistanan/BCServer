package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealdetail;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 报餐明细业务对象 bc_mealdetail
 *
 * @author anan
 * @date 2023-11-17
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
    @NotBlank(message = "用餐时段不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodGrounding;

    /**
     * 部门。部门id
     */
    @NotNull(message = "部门。部门id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deptId;

    /**
     * 职务。职务id
     */
    @NotNull(message = "职务。职务id不能为空", groups = { AddGroup.class, EditGroup.class })
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
    @NotBlank(message = "用餐状态(0待用餐，1已用餐，2退款，3其他)不能为空", groups = { AddGroup.class, EditGroup.class })
    private String dinnerStatus;

    /**
     * 验证方式
     */
    @NotBlank(message = "验证方式不能为空", groups = { AddGroup.class, EditGroup.class })
    private String authType;

    /**
     * 报餐时间
     */
    @NotNull(message = "报餐时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date bcTime;

    /**
     * 核销时间
     */
    @NotBlank(message = "核销时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private String verificationTime;

    /**
     * 状态（0正常 1停用）
     */
    @NotBlank(message = "状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

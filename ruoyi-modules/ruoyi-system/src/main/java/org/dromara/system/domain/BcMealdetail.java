package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 报餐明细对象 bc_mealdetail
 *
 * @author anan
 * @date 2023-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealdetail")
public class BcMealdetail extends TenantEntity {

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
    private Long foodGrounding;

    /**
     * 部门。部门id
     */
    private Long deptId;

    /**
     * 职务。职务id
     */
    private Long jobId;

    /**
     * 用餐类型
     */
    private Long foodTypeid;

    /**
     * 订单明细
     */
    private Long orderId;

    /**
     * 金额
     */
    private BigDecimal sumPrice;

    /**
     * 订餐人姓名
     */
    private String customerName;

    /**
     * 订餐人联系电话
     */
    private String customerPhone;

    /**
     * 用餐日期
     */
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
    private String verificationTime;

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

package org.dromara.system.domain.vo;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 订单明细对象 bc_orderdetail
 *
 * @author 周强
 * @date 2023-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_orderdetail")
public class BcOrderdetail extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 关联订单id
     */
    private Long detailId;

    /**
     * 用餐时段
     */
    private Long foodGrounding;

    /**
     * 菜品名称
     */
    private Long foodId;

    /**
     * 份数
     */
    private Integer foodNumber;

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

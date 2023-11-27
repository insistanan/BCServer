package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.vo.BcOrderdetail;

/**
 * 订单明细业务对象 bc_orderdetail
 *
 * @author 周强
 * @date 2023-11-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcOrderdetail.class, reverseConvertGenerate = false)
public class BcOrderdetailBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 关联订单id
     */
    @NotNull(message = "关联订单id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long detailId;

    /**
     * 用餐时段
     */
    @NotNull(message = "用餐时段不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodGrounding;

    /**
     * 菜品名称
     */
    @NotNull(message = "菜品名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodId;

    /**
     * 份数
     */
    @NotNull(message = "份数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer foodNumber;

    /**
     * 状态（0正常 1停用）
     */
    @NotBlank(message = "状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

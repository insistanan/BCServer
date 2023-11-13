package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcDinernoreview;

/**
 * 免审核人员业务对象 bc_dinernoreview
 *
 * @author 周强
 * @date 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcDinernoreview.class, reverseConvertGenerate = false)
public class BcDinernoreviewBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personName;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personTel;

    /**
     * 部门
     */
    @NotNull(message = "部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long personDinerdeptid;

    /**
     * 职务
     */
    @NotNull(message = "职务不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long personDinerjobid;

    /**
     * 状态（0正常 1停用）
     */
    @NotBlank(message = "状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

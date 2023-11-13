package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcDinerjob;

/**
 * 职务设置业务对象 bc_dinerjob
 *
 * @author 周强
 * @date 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcDinerjob.class, reverseConvertGenerate = false)
public class BcDinerjobBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 职位名称
     */
    @NotBlank(message = "职位名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String jobName;

    /**
     * 显示顺序
     */
    @NotNull(message = "显示顺序不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer orderNum;

    /**
     * 状态（0正常 1停用）
     */
    @NotBlank(message = "状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

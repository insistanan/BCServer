package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcDinerperson;

/**
 * 用餐人员信息业务对象 bc_dinerperson
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcDinerperson.class, reverseConvertGenerate = false)
public class BcDinerpersonBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 工号
     */
    @NotBlank(message = "工号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personCode;

    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personName;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personTel;

    /**
     * 职工卡号
     */
    @NotBlank(message = "职工卡号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personCardno;

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
     * 头像
     */
    @NotNull(message = "头像不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long personHeadimg;

    /**
     * 状态（0正常 1停用）
     */
    @NotBlank(message = "状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

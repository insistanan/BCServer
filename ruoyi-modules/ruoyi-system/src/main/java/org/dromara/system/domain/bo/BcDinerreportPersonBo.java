package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcDinerreportPerson;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 未实际就餐统计业务对象 bc_dinerreport_person
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcDinerreportPerson.class, reverseConvertGenerate = false)
public class BcDinerreportPersonBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 客户姓名
     */
    @NotBlank(message = "客户姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String customerName;

    /**
     * 部门
     */
    @NotBlank(message = "部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private String deptName;

    /**
     * 职务
     */
    @NotBlank(message = "职务不能为空", groups = { AddGroup.class, EditGroup.class })
    private String jobName;

    /**
     * 用餐时段
     */
    @NotBlank(message = "用餐时段不能为空", groups = { AddGroup.class, EditGroup.class })
    private String servetimeName;

    /**
     * 未实际就餐数
     */
    @NotNull(message = "未实际就餐数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer unusenum;

    /**
     * 时段未实际就餐数
     */
    @NotNull(message = "时段未实际就餐数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer singleunusenum;


}

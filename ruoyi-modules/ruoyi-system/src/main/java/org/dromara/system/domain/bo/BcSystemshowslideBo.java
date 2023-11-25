package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcSystemshowslide;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 首页幻灯片业务对象 bc_systemshowslide
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcSystemshowslide.class, reverseConvertGenerate = false)
public class BcSystemshowslideBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空", groups = { AddGroup.class, EditGroup.class })
    private String title;

    /**
     * 图片地址
     */
    @NotBlank(message = "图片地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String path;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer sort;

    /**
     * 状态，0-有效，1-失效
     */
    private String status;


}

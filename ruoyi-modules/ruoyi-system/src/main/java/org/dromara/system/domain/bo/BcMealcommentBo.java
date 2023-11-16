package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealcomment;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 评论业务对象 bc_mealcomment
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealcomment.class, reverseConvertGenerate = false)
public class BcMealcommentBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 评论
     */
    @NotBlank(message = "评论不能为空", groups = { AddGroup.class, EditGroup.class })
    private String comment;

    /**
     * 星级
     */
    @NotNull(message = "星级不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long score;

    /**
     * 菜品上架时间段，1-早餐，2-午餐，3-晚餐
     */
    @NotBlank(message = "菜品上架时间段，1-早餐，2-午餐，3-晚餐不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodGrounding;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String personName;

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
     * 评论时间
     */
    @NotNull(message = "评论时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date commentTime;


}

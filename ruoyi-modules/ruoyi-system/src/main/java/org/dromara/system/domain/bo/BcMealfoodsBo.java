package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealfoods;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 菜品业务对象 bc_mealfoods
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealfoods.class, reverseConvertGenerate = false)
public class BcMealfoodsBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 菜品名称
     */
    @NotBlank(message = "菜品名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodName;

    /**
     * 菜品价格
     */
    @NotNull(message = "菜品价格不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodPrice;

    /**
     * 菜品上架时间段，1-早餐，2-午餐，3-晚餐
     */
    @NotBlank(message = "菜品上架时间段，1-早餐，2-午餐，3-晚餐不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodGrounding;

    /**
     * 菜品上架日期，1-7代表周一至周日
     */
    @NotBlank(message = "菜品上架日期，1-7代表周一至周日不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodServerday;

    /**
     * 菜品类型
     */
    @NotNull(message = "菜品类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodTypeid;

    /**
     * 是否自动上架，0-是，1-否
     */
    @NotBlank(message = "是否自动上架，0-是，1-否不能为空", groups = { AddGroup.class, EditGroup.class })
    private String autoGrounding;

    /**
     * 限购份数
     */
    @NotNull(message = "限购份数不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long limitNum;

    /**
     * 预设库存
     */
    @NotBlank(message = "预设库存不能为空", groups = { AddGroup.class, EditGroup.class })
    private String stockNum;

    /**
     * 第一份减免
     */
    @NotBlank(message = "第一份减免不能为空", groups = { AddGroup.class, EditGroup.class })
    private String firstReduce;

    /**
     * 菜品描述
     */
    @NotBlank(message = "菜品描述不能为空", groups = { AddGroup.class, EditGroup.class })
    private String explain;

    /**
     * 开放类型，0-指定部门开放，1-全部开放
     */
    @NotBlank(message = "开放类型，0-指定部门开放，1-全部开放不能为空", groups = { AddGroup.class, EditGroup.class })
    private String openType;

    /**
     * 开放部门
     */
    @NotBlank(message = "开放部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private String enDept;

    /**
     * 开放职务
     */
    @NotBlank(message = "开放职务不能为空", groups = { AddGroup.class, EditGroup.class })
    private String enJob;

    /**
     * 菜品图片
     */
    @NotBlank(message = "菜品图片不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodImg;


}

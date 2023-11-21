package org.dromara.system.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcMealdailymenu;

import java.util.Date;

/**
 * 每日菜谱业务对象 bc_mealdailymenu
 *
 * @author 周强
 * @date 2023-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealdailymenu.class, reverseConvertGenerate = false)
public class BcMealdailymenuBo extends BaseEntity {

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
     * 菜品类型
     */
    @NotBlank(message = "菜品类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodtypeName;

    /**
     * 菜品价格
     */
    @NotNull(message = "菜品价格不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodPrice;

    /**
     * 预设库存
     */
    @NotBlank(message = "预设库存不能为空", groups = { AddGroup.class, EditGroup.class })
    private String stockNum;

    /**
     * 菜品图片
     */
    @NotBlank(message = "菜品图片不能为空", groups = { AddGroup.class, EditGroup.class })
    private String foodImg;

    /**
     * 用餐时段
     */
    @NotBlank(message = "用餐时段不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long foodGrounding;

    /**
     * 查询时间
     */
    @NotNull(message = "查询时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date searchTime;


}

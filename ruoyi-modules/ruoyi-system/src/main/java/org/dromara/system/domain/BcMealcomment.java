package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * 评论对象 bc_mealcomment
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealcomment")
public class BcMealcomment extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 评论
     */
    private String comment;

    /**
     * 星级
     */
    private Long score;

    /**
     * 菜品上架时间段，1-早餐，2-午餐，3-晚餐
     */
    private String foodGrounding;

    /**
     * 姓名
     */
    private String personName;

    /**
     * 部门
     */
    private Long personDinerdeptid;

    /**
     * 职务
     */
    private Long personDinerjobid;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

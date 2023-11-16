package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 菜品对象 bc_mealfoods
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealfoods")
public class BcMealfoods extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 菜品名称
     */
    private String foodName;

    /**
     * 菜品价格
     */
    private Long foodPrice;

    /**
     * 菜品上架时间段，1-早餐，2-午餐，3-晚餐
     */
    private String foodGrounding;

    /**
     * 菜品上架日期，1-7代表周一至周日
     */
    private String foodServerday;

    /**
     * 菜品类型
     */
    private Long foodTypeid;

    /**
     * 是否自动上架，0-是，1-否
     */
    private String autoGrounding;

    /**
     * 限购份数
     */
    private Long limitNum;

    /**
     * 预设库存
     */
    private String stockNum;

    /**
     * 第一份减免
     */
    private String firstReduce;

    /**
     * 菜品描述
     */
    private String explain;

    /**
     * 开放类型，0-指定部门开放，1-全部开放
     */
    private String openType;

    /**
     * 开放部门
     */
    private String enDept;

    /**
     * 开放职务
     */
    private String enJob;

    /**
     * 菜品图片
     */
    private String foodImg;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

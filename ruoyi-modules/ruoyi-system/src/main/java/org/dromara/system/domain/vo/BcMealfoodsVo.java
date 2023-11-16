package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcMealfoods;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 菜品视图对象 bc_mealfoods
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealfoods.class)
public class BcMealfoodsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 菜品名称
     */
    @ExcelProperty(value = "菜品名称")
    private String foodName;

    /**
     * 菜品价格
     */
    @ExcelProperty(value = "菜品价格")
    private Long foodPrice;

    /**
     * 菜品上架时间段，1-早餐，2-午餐，3-晚餐
     */
    @ExcelProperty(value = "菜品上架时间段，1-早餐，2-午餐，3-晚餐")
    private String foodGrounding;

    /**
     * 菜品上架日期，1-7代表周一至周日
     */
    @ExcelProperty(value = "菜品上架日期，1-7代表周一至周日")
    private String foodServerday;

    /**
     * 菜品类型
     */
    @ExcelProperty(value = "菜品类型")
    private Long foodTypeid;

    /**
     * 是否自动上架，0-是，1-否
     */
    @ExcelProperty(value = "是否自动上架，0-是，1-否")
    private String autoGrounding;

    /**
     * 限购份数
     */
    @ExcelProperty(value = "限购份数")
    private Long limitNum;

    /**
     * 预设库存
     */
    @ExcelProperty(value = "预设库存")
    private String stockNum;

    /**
     * 第一份减免
     */
    @ExcelProperty(value = "第一份减免")
    private String firstReduce;

    /**
     * 菜品描述
     */
    @ExcelProperty(value = "菜品描述")
    private String explain;

    /**
     * 开放类型，0-指定部门开放，1-全部开放
     */
    @ExcelProperty(value = "开放类型，0-指定部门开放，1-全部开放")
    private String openType;

    /**
     * 开放部门
     */
    @ExcelProperty(value = "开放部门")
    private String enDept;

    /**
     * 开放职务
     */
    @ExcelProperty(value = "开放职务")
    private String enJob;

    /**
     * 菜品图片
     */
    @ExcelProperty(value = "菜品图片")
    private String foodImg;


}

package org.dromara.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.system.domain.BcMealcomment;
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
 * 评论视图对象 bc_mealcomment
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealcomment.class)
public class BcMealcommentVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 评论
     */
    @ExcelProperty(value = "评论")
    private String comment;

    /**
     * 星级
     */
    @ExcelProperty(value = "星级")
    private Long score;

    /**
     * 菜品上架时间段，1-早餐，2-午餐，3-晚餐
     */
    @ExcelProperty(value = "菜品上架时间段，1-早餐，2-午餐，3-晚餐")
    private String foodGrounding;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    private String personName;

    /**
     * 部门
     */
    @ExcelProperty(value = "部门")
    private Long personDinerdeptid;

    /**
     * 职务
     */
    @ExcelProperty(value = "职务")
    private Long personDinerjobid;

    /**
     * 评论时间
     */
    @ExcelProperty(value = "评论时间")
    private Date commentTime;


}

package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcMealservetime;
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
 * 用餐时段视图对象 bc_mealservetime
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealservetime.class)
public class BcMealservetimeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    private String servetimeName;

    /**
     * 时段可报份数
     */
    @ExcelProperty(value = "时段可报份数")
    private Long servetimeNum;

    /**
     * 状态，0-开启，1关闭
     */
    @ExcelProperty(value = "状态，0-开启，1关闭")
    private String servetimeStatus;

    /**
     * 开始时间
     */
    @ExcelProperty(value = "开始时间")
    private String servetimeBegin;

    /**
     * 结束时间
     */
    @ExcelProperty(value = "结束时间")
    private String servetimeEnd;

    /**
     * 报餐提醒状态，0-开启，1关闭
     */
    @ExcelProperty(value = "报餐提醒状态，0-开启，1关闭")
    private String servetimeRemindstatus;

    /**
     * 报餐提醒时间
     */
    @ExcelProperty(value = "报餐提醒时间")
    private String servetimeRemind;

    /**
     * 报餐截止天数
     */
    @ExcelProperty(value = "报餐截止天数")
    private String servetimeRepotrendday;

    /**
     * 报餐截止时间
     */
    @ExcelProperty(value = "报餐截止时间")
    private String servetimeRepotrendtime;


}

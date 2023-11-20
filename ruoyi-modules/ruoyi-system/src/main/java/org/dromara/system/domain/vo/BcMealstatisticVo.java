package org.dromara.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.system.domain.BcMealstatistic;
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
 * 报餐统计视图对象 bc_mealstatistic
 *
 * @author anan
 * @date 2023-11-18
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealstatistic.class)
public class BcMealstatisticVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 用餐时段
     */
    @ExcelProperty(value = "用餐时段", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_mealservetime")
    private String foodGrounding;

    /**
     * 部门。部门id
     */
    @ExcelProperty(value = "部门。部门id", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_dinerdept")
    private Long deptId;

    /**
     * 职务。职务id
     */
    @ExcelProperty(value = "职务。职务id", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_dinerjob")
    private Long jobId;

    /**
     * 餐品名称
     */
    @ExcelProperty(value = "餐品名称")
    private String foodName;

    /**
     * 报餐时间
     */
    @ExcelProperty(value = "报餐时间")
    private Date bcTime;


}

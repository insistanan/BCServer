package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 用餐人员部门视图对象 bc_dinerdept
 *
 * @author 周强
 * @date 2023-11-13
 */
@Data
public class ApiOrderMealVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用餐时段
     */
    @ExcelProperty(value = "用餐时段", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_mealservetime")
    private Long foodGrounding;

    /**
     * 用餐类型
     */
    @ExcelProperty(value = "用餐类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_mealfoodtype")
    private Long foodTypeid;

    /**
     * 订单明细
     */
    @ExcelProperty(value = "订单明细")
    private String orderDetail;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户ID")
    private Long personId;

    /**
     * 用餐日期
     */
    @ExcelProperty(value = "用餐日期")
    private Date dinnerTime;

    /**
     * 报餐时间
     */
    @ExcelProperty(value = "报餐时间")
    private Date bcTime;


}

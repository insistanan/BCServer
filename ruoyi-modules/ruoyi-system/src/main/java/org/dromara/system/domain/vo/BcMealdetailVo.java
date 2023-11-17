package org.dromara.system.domain.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.dromara.system.domain.BcMealdetail;
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
 * 报餐明细视图对象 bc_mealdetail
 *
 * @author anan
 * @date 2023-11-17
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealdetail.class)
public class BcMealdetailVo implements Serializable {

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
     * 用餐类型
     */
    @ExcelProperty(value = "用餐类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_mealfoodtype")
    private Long foodTypeid;

    /**
     * 订单明细
     */
    @ExcelProperty(value = "订单明细")
    private Long orderId;

    /**
     * 金额
     */
    @ExcelProperty(value = "金额")
    private BigDecimal sumPrice;

    /**
     * 订餐人姓名
     */
    @ExcelProperty(value = "订餐人姓名")
    private String customerName;

    /**
     * 订餐人联系电话
     */
    @ExcelProperty(value = "订餐人联系电话")
    private String customerPhone;

    /**
     * 用餐日期
     */
    @ExcelProperty(value = "用餐日期")
    private Date dinnerTime;

    /**
     * 用餐状态(0待用餐，1已用餐，2退款，3其他)
     */
    @ExcelProperty(value = "用餐状态(0待用餐，1已用餐，2退款，3其他)")
    private String dinnerStatus;

    /**
     * 验证方式
     */
    @ExcelProperty(value = "验证方式")
    private String authType;

    /**
     * 报餐时间
     */
    @ExcelProperty(value = "报餐时间")
    private Date bcTime;

    /**
     * 核销时间
     */
    @ExcelProperty(value = "核销时间")
    private String verificationTime;

    /**
     * 状态（0正常 1停用）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=停用")
    private String status;


}

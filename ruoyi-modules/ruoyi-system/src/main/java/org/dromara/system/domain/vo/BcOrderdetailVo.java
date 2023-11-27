package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;



/**
 * 订单明细视图对象 bc_orderdetail
 *
 * @author 周强
 * @date 2023-11-26
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcOrderdetail.class)
public class BcOrderdetailVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 关联订单id
     */
    @ExcelProperty(value = "关联订单id")
    private Long detailId;

    /**
     * 用餐时段
     */
    @ExcelProperty(value = "用餐时段")
    private Long foodGrounding;

    /**
     * 菜品名称
     */
    @ExcelProperty(value = "菜品名称")
    private Long foodId;

    /**
     * 份数
     */
    @ExcelProperty(value = "份数")
    private Integer foodNumber;

    /**
     * 状态（0正常 1停用）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=正常,1=停用")
    private String status;


}

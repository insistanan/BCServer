package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.system.domain.BcDinerreportServetime;

import java.io.Serial;
import java.io.Serializable;



/**
 * 时段就餐统计视图对象 bc_dinerreport_servetime
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcDinerreportServetime.class)
public class BcDinerreportServetimeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 部门
     */
    @ExcelProperty(value = "部门")
    private String deptName;

    /**
     * 用餐时段
     */
    @ExcelProperty(value = "用餐时段")
    private String servetimeName;

    /**
     * 已报餐数
     */
    @ExcelProperty(value = "已报餐数")
    private Integer dinertotalnum;

    /**
     * 实际就餐数
     */
    @ExcelProperty(value = "实际就餐数")
    private Integer usedinernum;

    /**
     * 未实际就餐数
     */
    @ExcelProperty(value = "未实际就餐数")
    private Integer unusedinernum;


}

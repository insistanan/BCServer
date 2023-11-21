package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcDinerreportPerson;
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
 * 未实际就餐统计视图对象 bc_dinerreport_person
 *
 * @author 周强
 * @date 2023-11-21
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcDinerreportPerson.class)
public class BcDinerreportPersonVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 客户姓名
     */
    @ExcelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 部门
     */
    @ExcelProperty(value = "部门")
    private String deptName;

    /**
     * 职务
     */
    @ExcelProperty(value = "职务")
    private String jobName;

    /**
     * 用餐时段
     */
    @ExcelProperty(value = "用餐时段")
    private String servetimeName;

    /**
     * 未实际就餐数
     */
    @ExcelProperty(value = "未实际就餐数")
    private Integer unusenum;

    /**
     * 时段未实际就餐数
     */
    @ExcelProperty(value = "时段未实际就餐数")
    private Integer singleunusenum;


}

package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.system.domain.BcDinernoreview;

import java.io.Serial;
import java.io.Serializable;



/**
 * 免审核人员视图对象 bc_dinernoreview
 *
 * @author 周强
 * @date 2023-11-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcDinernoreview.class)
public class BcDinernoreviewVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 部门名称
     */
    @ExcelProperty(value = "部门名称")
    private String personName;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String personTel;

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
     * 状态（0正常 1停用）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;


}

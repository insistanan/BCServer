package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.system.domain.BcDinerjob;

import java.io.Serial;
import java.io.Serializable;



/**
 * 职务设置视图对象 bc_dinerjob
 *
 * @author 周强
 * @date 2023-11-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcDinerjob.class)
public class BcDinerjobVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 职位名称
     */
    @ExcelProperty(value = "职位名称")
    private String jobName;

    /**
     * 显示顺序
     */
    @ExcelProperty(value = "显示顺序")
    private Integer orderNum;

    /**
     * 状态（0正常 1停用）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;


}

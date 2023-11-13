package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.system.domain.BcDinerperson;

import java.io.Serial;
import java.io.Serializable;



/**
 * 用餐人员信息视图对象 bc_dinerperson
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcDinerperson.class)
public class BcDinerpersonVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 工号
     */
    @ExcelProperty(value = "工号")
    private String personCode;

    /**
     * 昵称
     */
    @ExcelProperty(value = "昵称")
    private String personName;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String personTel;

    /**
     * 职工卡号
     */
    @ExcelProperty(value = "职工卡号")
    private String personCardno;

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
     * 头像
     */
    @ExcelProperty(value = "头像")
    private Long personHeadimg;

    /**
     * 状态（0正常 1停用）
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;


}

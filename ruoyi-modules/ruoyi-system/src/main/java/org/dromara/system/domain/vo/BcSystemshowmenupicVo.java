package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcSystemshowmenupic;
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
 * 菜谱图片视图对象 bc_systemshowmenupic
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcSystemshowmenupic.class)
public class BcSystemshowmenupicVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 图片地址
     */
    @ExcelProperty(value = "图片地址")
    private String path;


}

package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcMealkeyword;
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
 * 关键词视图对象 bc_mealkeyword
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealkeyword.class)
public class BcMealkeywordVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 关键词
     */
    @ExcelProperty(value = "关键词")
    private String keywordName;


}

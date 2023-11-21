package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcSystemshownotice;
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
 * 公告视图对象 bc_systemshownotice
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcSystemshownotice.class)
public class BcSystemshownoticeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 公告名称
     */
    @ExcelProperty(value = "公告名称")
    private String noticeName;

    /**
     * 公告顺序
     */
    @ExcelProperty(value = "公告顺序")
    private Integer noticeSort;

    /**
     * 公告装填（0-有效，1-失效）
     */
    @ExcelProperty(value = "公告装填", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=-有效，1-失效")
    private String noticeStatus;

    /**
     * 公告内容
     */
    @ExcelProperty(value = "公告内容")
    private String noticeContent;


}

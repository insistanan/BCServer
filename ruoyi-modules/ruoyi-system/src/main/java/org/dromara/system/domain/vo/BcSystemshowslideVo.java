package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcSystemshowslide;
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
 * 首页幻灯片视图对象 bc_systemshowslide
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcSystemshowslide.class)
public class BcSystemshowslideVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    private String title;

    /**
     * 图片地址
     */
    @ExcelProperty(value = "图片地址")
    private String path;

    /**
     * 排序
     */
    @ExcelProperty(value = "排序")
    private Integer sort;

    /**
     * 状态，0-有效，1-失效
     */
    @ExcelProperty(value = "状态，0-有效，1-失效")
    private String status;


}

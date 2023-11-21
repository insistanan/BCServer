package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.system.domain.BcMealdailymenu;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 每日菜谱视图对象 bc_mealdailymenu
 *
 * @author 周强
 * @date 2023-11-17
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealdailymenu.class)
public class BcMealdailymenuVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 菜品名称
     */
    @ExcelProperty(value = "菜品名称")
    private String foodName;

    /**
     * 菜品类型
     */
    @ExcelProperty(value = "菜品类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_mealfoodtype")
    private String foodtypeName;

    /**
     * 菜品价格
     */
    @ExcelProperty(value = "菜品价格")
    private Long foodPrice;

    /**
     * 预设库存
     */
    @ExcelProperty(value = "预设库存")
    private String stockNum;

    /**
     * 菜品图片
     */
    @ExcelProperty(value = "菜品图片")
    private String foodImg;

    /**
     * 用餐时段
     */
    @ExcelProperty(value = "用餐时段", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "bc_mealservetime")
    private String foodGrounding;

    /**
     * 查询时间
     */
    @ExcelProperty(value = "查询时间")
    private Date searchTime;


}

package org.dromara.system.domain.vo;

import org.dromara.system.domain.BcMealfoodtype;
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
 * 菜品类型视图对象 bc_mealfoodtype
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealfoodtype.class)
public class BcMealfoodtypeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 菜品类型
     */
    @ExcelProperty(value = "菜品类型")
    private String foodtypeName;


}

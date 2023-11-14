package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.system.domain.BcMealforbidday;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 禁止用餐日期视图对象 bc_mealforbidday
 *
 * @author 周强
 * @date 2023-11-14
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealforbidday.class)
public class BcMealforbiddayVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 禁止用餐日期
     */
    @ExcelProperty(value = "禁止用餐日期")
    private Date forbidDate;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型")
    private String forbidType;


}

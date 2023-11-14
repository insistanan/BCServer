package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.system.domain.BcMealservermode;

import java.io.Serial;
import java.io.Serializable;



/**
 * 开餐模式信息视图对象 bc_mealservermode
 *
 * @author 周强
 * @date 2023-11-14
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = BcMealservermode.class)
public class BcMealservermodeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 1-自选开餐，2-每日开餐，3-周日不开餐，4-周一到周五开餐
     */
    @ExcelProperty(value = "1-自选开餐，2-每日开餐，3-周日不开餐，4-周一到周五开餐")
    private String serverMode;

    /**
     * 开餐时间，1-7代表周一到周日
     */
    @ExcelProperty(value = "开餐时间，1-7代表周一到周日")
    private String serverDay;

    /**
     * 可提前报餐天数
     */
    @ExcelProperty(value = "可提前报餐天数")
    private Integer earlyDay;


}

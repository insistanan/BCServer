package org.dromara.system.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.system.domain.BcMealforbidday;

import java.util.Date;

/**
 * 禁止用餐日期业务对象 bc_mealforbidday
 *
 * @author 周强
 * @date 2023-11-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealforbidday.class, reverseConvertGenerate = false)
public class BcMealforbiddayBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 禁止用餐日期
     */
    @NotNull(message = "禁止用餐日期不能为空", groups = { AddGroup.class, EditGroup.class })
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Date forbidDate;


}

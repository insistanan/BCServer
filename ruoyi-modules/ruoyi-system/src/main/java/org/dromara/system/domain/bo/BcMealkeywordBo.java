package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcMealkeyword;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 关键词业务对象 bc_mealkeyword
 *
 * @author 周强
 * @date 2023-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcMealkeyword.class, reverseConvertGenerate = false)
public class BcMealkeywordBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 关键词
     */
    @NotBlank(message = "关键词不能为空", groups = { AddGroup.class, EditGroup.class })
    private String keywordName;


}

package org.dromara.system.domain.bo;

import org.dromara.system.domain.BcSystemshownotice;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 公告业务对象 bc_systemshownotice
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = BcSystemshownotice.class, reverseConvertGenerate = false)
public class BcSystemshownoticeBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 公告名称
     */
    @NotBlank(message = "公告名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String noticeName;

    /**
     * 公告顺序
     */
    @NotNull(message = "公告顺序不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer noticeSort;

    /**
     * 公告装填（0-有效，1-失效）
     */
    @NotBlank(message = "公告装填（0-有效，1-失效）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String noticeStatus;

    /**
     * 公告内容
     */
    @NotBlank(message = "公告内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String noticeContent;


}

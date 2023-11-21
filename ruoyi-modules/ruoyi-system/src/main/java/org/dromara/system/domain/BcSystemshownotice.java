package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 公告对象 bc_systemshownotice
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_systemshownotice")
public class BcSystemshownotice extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 公告名称
     */
    private String noticeName;

    /**
     * 公告顺序
     */
    private Integer noticeSort;

    /**
     * 公告装填（0-有效，1-失效）
     */
    private String noticeStatus;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

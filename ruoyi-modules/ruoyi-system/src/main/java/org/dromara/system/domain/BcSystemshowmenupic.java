package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 菜谱图片对象 bc_systemshowmenupic
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_systemshowmenupic")
public class BcSystemshowmenupic extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 图片地址
     */
    private String path;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

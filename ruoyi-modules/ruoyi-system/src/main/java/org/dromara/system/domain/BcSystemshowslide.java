package org.dromara.system.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 首页幻灯片对象 bc_systemshowslide
 *
 * @author 周强
 * @date 2023-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_systemshowslide")
public class BcSystemshowslide extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片地址
     */
    private String path;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态，0-有效，1-失效
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

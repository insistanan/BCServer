package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 每日菜谱对象 bc_mealdailymenu
 *
 * @author 周强
 * @date 2023-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bc_mealdailymenu")
public class BcMealdailymenu extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 菜品名称
     */
    private String foodName;

    /**
     * 菜品类型
     */
    private String foodtypeName;

    /**
     * 菜品价格
     */
    private Long foodPrice;

    /**
     * 预设库存
     */
    private String stockNum;

    /**
     * 菜品图片
     */
    private String foodImg;

    /**
     * 用餐时段
     */
    private String foodGrounding;

    /**
     * 查询时间
     */
    private Date searchTime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

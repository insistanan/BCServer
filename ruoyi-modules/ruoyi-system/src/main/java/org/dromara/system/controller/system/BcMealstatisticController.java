package org.dromara.system.controller.system;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.system.domain.vo.BcMealstatisticVo;
import org.dromara.system.domain.bo.BcMealstatisticBo;
import org.dromara.system.service.IBcMealstatisticService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 报餐统计
 *
 * @author anan
 * @date 2023-11-18
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealstatistic")
public class BcMealstatisticController extends BaseController {

    private final IBcMealstatisticService bcMealstatisticService;

    /**
     * 查询报餐统计列表
     */
    @SaCheckPermission("mealmanage:mealstatistic:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealstatisticVo> list(BcMealstatisticBo bo, PageQuery pageQuery) {
        return bcMealstatisticService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出报餐统计列表
     */
    @SaCheckPermission("mealmanage:mealstatistic:export")
    @Log(title = "报餐统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealstatisticBo bo, HttpServletResponse response) {
        List<BcMealstatisticVo> list = bcMealstatisticService.queryList(bo);
        ExcelUtil.exportExcel(list, "报餐统计", BcMealstatisticVo.class, response);
    }

    /**
     * 获取报餐统计详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealstatistic:query")
    @GetMapping("/{id}")
    public R<BcMealstatisticVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealstatisticService.queryById(id));
    }

    /**
     * 新增报餐统计
     */
    @SaCheckPermission("mealmanage:mealstatistic:add")
    @Log(title = "报餐统计", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealstatisticBo bo) {
        return toAjax(bcMealstatisticService.insertByBo(bo));
    }

    /**
     * 修改报餐统计
     */
    @SaCheckPermission("mealmanage:mealstatistic:edit")
    @Log(title = "报餐统计", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealstatisticBo bo) {
        return toAjax(bcMealstatisticService.updateByBo(bo));
    }

    /**
     * 删除报餐统计
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealstatistic:remove")
    @Log(title = "报餐统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealstatisticService.deleteWithValidByIds(List.of(ids), true));
    }
}

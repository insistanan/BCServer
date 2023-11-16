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
import org.dromara.system.domain.vo.BcMealservetimeVo;
import org.dromara.system.domain.bo.BcMealservetimeBo;
import org.dromara.system.service.IBcMealservetimeService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 用餐时段
 *
 * @author 周强
 * @date 2023-11-16
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealservetime")
public class BcMealservetimeController extends BaseController {

    private final IBcMealservetimeService bcMealservetimeService;

    /**
     * 查询用餐时段列表
     */
    @SaCheckPermission("mealmanage:mealservetime:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealservetimeVo> list(BcMealservetimeBo bo, PageQuery pageQuery) {
        return bcMealservetimeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出用餐时段列表
     */
    @SaCheckPermission("mealmanage:mealservetime:export")
    @Log(title = "用餐时段", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealservetimeBo bo, HttpServletResponse response) {
        List<BcMealservetimeVo> list = bcMealservetimeService.queryList(bo);
        ExcelUtil.exportExcel(list, "用餐时段", BcMealservetimeVo.class, response);
    }

    /**
     * 获取用餐时段详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealservetime:query")
    @GetMapping("/{id}")
    public R<BcMealservetimeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealservetimeService.queryById(id));
    }

    /**
     * 新增用餐时段
     */
    @SaCheckPermission("mealmanage:mealservetime:add")
    @Log(title = "用餐时段", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealservetimeBo bo) {
        return toAjax(bcMealservetimeService.insertByBo(bo));
    }

    /**
     * 修改用餐时段
     */
    @SaCheckPermission("mealmanage:mealservetime:edit")
    @Log(title = "用餐时段", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealservetimeBo bo) {
        return toAjax(bcMealservetimeService.updateByBo(bo));
    }

    /**
     * 删除用餐时段
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealservetime:remove")
    @Log(title = "用餐时段", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealservetimeService.deleteWithValidByIds(List.of(ids), true));
    }
}

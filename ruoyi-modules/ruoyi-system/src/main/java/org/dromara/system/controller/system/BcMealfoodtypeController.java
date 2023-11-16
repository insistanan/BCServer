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
import org.dromara.system.domain.vo.BcMealfoodtypeVo;
import org.dromara.system.domain.bo.BcMealfoodtypeBo;
import org.dromara.system.service.IBcMealfoodtypeService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 菜品类型
 *
 * @author 周强
 * @date 2023-11-16
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealfoodtype")
public class BcMealfoodtypeController extends BaseController {

    private final IBcMealfoodtypeService bcMealfoodtypeService;

    /**
     * 查询菜品类型列表
     */
    @SaCheckPermission("mealmanage:mealfoodtype:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealfoodtypeVo> list(BcMealfoodtypeBo bo, PageQuery pageQuery) {
        return bcMealfoodtypeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出菜品类型列表
     */
    @SaCheckPermission("mealmanage:mealfoodtype:export")
    @Log(title = "菜品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealfoodtypeBo bo, HttpServletResponse response) {
        List<BcMealfoodtypeVo> list = bcMealfoodtypeService.queryList(bo);
        ExcelUtil.exportExcel(list, "菜品类型", BcMealfoodtypeVo.class, response);
    }

    /**
     * 获取菜品类型详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealfoodtype:query")
    @GetMapping("/{id}")
    public R<BcMealfoodtypeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealfoodtypeService.queryById(id));
    }

    /**
     * 新增菜品类型
     */
    @SaCheckPermission("mealmanage:mealfoodtype:add")
    @Log(title = "菜品类型", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealfoodtypeBo bo) {
        return toAjax(bcMealfoodtypeService.insertByBo(bo));
    }

    /**
     * 修改菜品类型
     */
    @SaCheckPermission("mealmanage:mealfoodtype:edit")
    @Log(title = "菜品类型", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealfoodtypeBo bo) {
        return toAjax(bcMealfoodtypeService.updateByBo(bo));
    }

    /**
     * 删除菜品类型
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealfoodtype:remove")
    @Log(title = "菜品类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealfoodtypeService.deleteWithValidByIds(List.of(ids), true));
    }
}

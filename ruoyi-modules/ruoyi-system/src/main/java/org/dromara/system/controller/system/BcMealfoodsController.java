package org.dromara.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.bo.BcMealfoodsBo;
import org.dromara.system.domain.vo.BcMealfoodsVo;
import org.dromara.system.service.IBcMealfoodsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜品
 *
 * @author 周强
 * @date 2023-11-16
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealfoods")
public class BcMealfoodsController extends BaseController {

    private final IBcMealfoodsService bcMealfoodsService;

    /**
     * 查询菜品列表
     */
    @SaCheckPermission("mealmanage:mealfoods:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealfoodsVo> list(BcMealfoodsBo bo, PageQuery pageQuery) {
        return bcMealfoodsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出菜品列表
     */
    @SaCheckPermission("mealmanage:mealfoods:export")
    @Log(title = "菜品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealfoodsBo bo, HttpServletResponse response) {
        List<BcMealfoodsVo> list = bcMealfoodsService.queryList(bo);
        ExcelUtil.exportExcel(list, "菜品", BcMealfoodsVo.class, response);
    }

    /**
     * 获取菜品详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealfoods:query")
    @GetMapping("/{id}")
    public R<BcMealfoodsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealfoodsService.queryById(id));
    }

    /**
     * 新增菜品
     */
    @SaCheckPermission("mealmanage:mealfoods:add")
    @Log(title = "菜品", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealfoodsBo bo) {
        return toAjax(bcMealfoodsService.insertByBo(bo));
    }

    /**
     * 修改菜品
     */
    @SaCheckPermission("mealmanage:mealfoods:edit")
    @Log(title = "菜品", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealfoodsBo bo) {
        return toAjax(bcMealfoodsService.updateByBo(bo));
    }

    /**
     * 删除菜品
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealfoods:remove")
    @Log(title = "菜品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealfoodsService.deleteWithValidByIds(List.of(ids), true));
    }
}

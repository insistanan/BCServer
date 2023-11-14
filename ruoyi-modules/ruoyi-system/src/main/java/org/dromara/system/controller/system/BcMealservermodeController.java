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
import org.dromara.system.domain.bo.BcMealservermodeBo;
import org.dromara.system.domain.vo.BcMealservermodeVo;
import org.dromara.system.service.IBcMealservermodeService;
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
 * 开餐模式信息
 *
 * @author 周强
 * @date 2023-11-14
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealservermode")
public class BcMealservermodeController extends BaseController {

    private final IBcMealservermodeService bcMealservermodeService;

    /**
     * 查询开餐模式信息列表
     */
    @SaCheckPermission("mealmanage:mealservermode:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealservermodeVo> list(BcMealservermodeBo bo, PageQuery pageQuery) {
        return bcMealservermodeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出开餐模式信息列表
     */
    @SaCheckPermission("mealmanage:mealservermode:export")
    @Log(title = "开餐模式信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealservermodeBo bo, HttpServletResponse response) {
        List<BcMealservermodeVo> list = bcMealservermodeService.queryList(bo);
        ExcelUtil.exportExcel(list, "开餐模式信息", BcMealservermodeVo.class, response);
    }

    /**
     * 获取开餐模式信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealservermode:query")
    @GetMapping("/{id}")
    public R<BcMealservermodeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealservermodeService.queryById(id));
    }

    /**
     * 新增开餐模式信息
     */
    @SaCheckPermission("mealmanage:mealservermode:add")
    @Log(title = "开餐模式信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealservermodeBo bo) {
        return toAjax(bcMealservermodeService.insertByBo(bo));
    }

    /**
     * 修改开餐模式信息
     */
    @SaCheckPermission("mealmanage:mealservermode:edit")
    @Log(title = "开餐模式信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealservermodeBo bo) {
        return toAjax(bcMealservermodeService.updateByBo(bo));
    }

    /**
     * 删除开餐模式信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealservermode:remove")
    @Log(title = "开餐模式信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealservermodeService.deleteWithValidByIds(List.of(ids), true));
    }
}

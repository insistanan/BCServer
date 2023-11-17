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
import org.dromara.system.domain.vo.BcMealdetailVo;
import org.dromara.system.domain.bo.BcMealdetailBo;
import org.dromara.system.service.IBcMealdetailService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 报餐明细
 *
 * @author anan
 * @date 2023-11-17
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealdetail")
public class BcMealdetailController extends BaseController {

    private final IBcMealdetailService bcMealdetailService;

    /**
     * 查询报餐明细列表
     */
    @SaCheckPermission("mealmanage:mealdetail:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealdetailVo> list(BcMealdetailBo bo, PageQuery pageQuery) {
        return bcMealdetailService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出报餐明细列表
     */
    @SaCheckPermission("mealmanage:mealdetail:export")
    @Log(title = "报餐明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealdetailBo bo, HttpServletResponse response) {
        List<BcMealdetailVo> list = bcMealdetailService.queryList(bo);
        ExcelUtil.exportExcel(list, "报餐明细", BcMealdetailVo.class, response);
    }

    /**
     * 获取报餐明细详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealdetail:query")
    @GetMapping("/{id}")
    public R<BcMealdetailVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealdetailService.queryById(id));
    }

    /**
     * 新增报餐明细
     */
    @SaCheckPermission("mealmanage:mealdetail:add")
    @Log(title = "报餐明细", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealdetailBo bo) {
        return toAjax(bcMealdetailService.insertByBo(bo));
    }

    /**
     * 修改报餐明细
     */
    @SaCheckPermission("mealmanage:mealdetail:edit")
    @Log(title = "报餐明细", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealdetailBo bo) {
        return toAjax(bcMealdetailService.updateByBo(bo));
    }

    /**
     * 删除报餐明细
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealdetail:remove")
    @Log(title = "报餐明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealdetailService.deleteWithValidByIds(List.of(ids), true));
    }
}

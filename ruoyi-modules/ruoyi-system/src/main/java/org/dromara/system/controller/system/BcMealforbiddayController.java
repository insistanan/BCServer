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
import org.dromara.system.domain.bo.BcMealforbiddayBo;
import org.dromara.system.domain.vo.BcMealforbiddayVo;
import org.dromara.system.service.IBcMealforbiddayService;
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
 * 禁止用餐日期
 *
 * @author 周强
 * @date 2023-11-14
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealforbidday")
public class BcMealforbiddayController extends BaseController {

    private final IBcMealforbiddayService bcMealforbiddayService;

    /**
     * 查询禁止用餐日期列表
     */
    @SaCheckPermission("mealmanage:mealforbidday:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealforbiddayVo> list(BcMealforbiddayBo bo, PageQuery pageQuery) {
        return bcMealforbiddayService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出禁止用餐日期列表
     */
    @SaCheckPermission("mealmanage:mealforbidday:export")
    @Log(title = "禁止用餐日期", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealforbiddayBo bo, HttpServletResponse response) {
        List<BcMealforbiddayVo> list = bcMealforbiddayService.queryList(bo);
        ExcelUtil.exportExcel(list, "禁止用餐日期", BcMealforbiddayVo.class, response);
    }

    /**
     * 获取禁止用餐日期详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealforbidday:query")
    @GetMapping("/{id}")
    public R<BcMealforbiddayVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealforbiddayService.queryById(id));
    }

    /**
     * 新增禁止用餐日期
     */
    @SaCheckPermission("mealmanage:mealforbidday:add")
    @Log(title = "禁止用餐日期", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealforbiddayBo bo) {
        return toAjax(bcMealforbiddayService.insertByBo(bo));
    }

    /**
     * 修改禁止用餐日期
     */
    @SaCheckPermission("mealmanage:mealforbidday:edit")
    @Log(title = "禁止用餐日期", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealforbiddayBo bo) {
        return toAjax(bcMealforbiddayService.updateByBo(bo));
    }

    /**
     * 删除禁止用餐日期
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealforbidday:remove")
    @Log(title = "禁止用餐日期", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealforbiddayService.deleteWithValidByIds(List.of(ids), true));
    }
}

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
import org.dromara.system.domain.bo.BcMealdailymenuBo;
import org.dromara.system.domain.vo.BcMealdailymenuVo;
import org.dromara.system.service.IBcMealdailymenuService;
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
 * 每日菜谱
 *
 * @author 周强
 * @date 2023-11-17
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealdailymenu")
public class BcMealdailymenuController extends BaseController {

    private final IBcMealdailymenuService bcMealdailymenuService;

    /**
     * 查询每日菜谱列表
     */
    @SaCheckPermission("mealmanage:mealdailymenu:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealdailymenuVo> list(BcMealdailymenuBo bo, PageQuery pageQuery) {
        return bcMealdailymenuService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出每日菜谱列表
     */
    @SaCheckPermission("mealmanage:mealdailymenu:export")
    @Log(title = "每日菜谱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealdailymenuBo bo, HttpServletResponse response) {
        List<BcMealdailymenuVo> list = bcMealdailymenuService.queryList(bo);
        ExcelUtil.exportExcel(list, "每日菜谱", BcMealdailymenuVo.class, response);
    }

    /**
     * 获取每日菜谱详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealdailymenu:query")
    @GetMapping("/{id}")
    public R<BcMealdailymenuVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealdailymenuService.queryById(id));
    }

    /**
     * 新增每日菜谱
     */
    @SaCheckPermission("mealmanage:mealdailymenu:add")
    @Log(title = "每日菜谱", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealdailymenuBo bo) {
        return toAjax(bcMealdailymenuService.insertByBo(bo));
    }

    /**
     * 修改每日菜谱
     */
    @SaCheckPermission("mealmanage:mealdailymenu:edit")
    @Log(title = "每日菜谱", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealdailymenuBo bo) {
        return toAjax(bcMealdailymenuService.updateByBo(bo));
    }

    /**
     * 删除每日菜谱
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealdailymenu:remove")
    @Log(title = "每日菜谱", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealdailymenuService.deleteWithValidByIds(List.of(ids), true));
    }
}

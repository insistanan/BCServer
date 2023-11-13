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
import org.dromara.system.domain.bo.BcDinerdeptBo;
import org.dromara.system.domain.vo.BcDinerdeptVo;
import org.dromara.system.service.IBcDinerdeptService;
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
 * 用餐人员部门
 *
 * @author 周强
 * @date 2023-11-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinermanage/dinerdept")
public class BcDinerdeptController extends BaseController {

    private final IBcDinerdeptService bcDinerdeptService;

    /**
     * 查询用餐人员部门列表
     */
    @SaCheckPermission("dinermanage:dinerdept:list")
    @GetMapping("/list")
    public TableDataInfo<BcDinerdeptVo> list(BcDinerdeptBo bo, PageQuery pageQuery) {
        return bcDinerdeptService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出用餐人员部门列表
     */
    @SaCheckPermission("dinermanage:dinerdept:export")
    @Log(title = "用餐人员部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinerdeptBo bo, HttpServletResponse response) {
        List<BcDinerdeptVo> list = bcDinerdeptService.queryList(bo);
        ExcelUtil.exportExcel(list, "用餐人员部门", BcDinerdeptVo.class, response);
    }

    /**
     * 获取用餐人员部门详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("dinermanage:dinerdept:query")
    @GetMapping("/{id}")
    public R<BcDinerdeptVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcDinerdeptService.queryById(id));
    }

    /**
     * 新增用餐人员部门
     */
    @SaCheckPermission("dinermanage:dinerdept:add")
    @Log(title = "用餐人员部门", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcDinerdeptBo bo) {
        return toAjax(bcDinerdeptService.insertByBo(bo));
    }

    /**
     * 修改用餐人员部门
     */
    @SaCheckPermission("dinermanage:dinerdept:edit")
    @Log(title = "用餐人员部门", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcDinerdeptBo bo) {
        return toAjax(bcDinerdeptService.updateByBo(bo));
    }

    /**
     * 删除用餐人员部门
     *
     * @param ids 主键串
     */
    @SaCheckPermission("dinermanage:dinerdept:remove")
    @Log(title = "用餐人员部门", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcDinerdeptService.deleteWithValidByIds(List.of(ids), true));
    }
}

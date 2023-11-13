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
import org.dromara.system.domain.bo.BcDinernoreviewBo;
import org.dromara.system.domain.vo.BcDinernoreviewVo;
import org.dromara.system.service.IBcDinernoreviewService;
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
 * 免审核人员
 *
 * @author 周强
 * @date 2023-11-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinermanage/dinernoreview")
public class BcDinernoreviewController extends BaseController {

    private final IBcDinernoreviewService bcDinernoreviewService;

    /**
     * 查询免审核人员列表
     */
    @SaCheckPermission("dinermanage:dinernoreview:list")
    @GetMapping("/list")
    public TableDataInfo<BcDinernoreviewVo> list(BcDinernoreviewBo bo, PageQuery pageQuery) {
        return bcDinernoreviewService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出免审核人员列表
     */
    @SaCheckPermission("dinermanage:dinernoreview:export")
    @Log(title = "免审核人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinernoreviewBo bo, HttpServletResponse response) {
        List<BcDinernoreviewVo> list = bcDinernoreviewService.queryList(bo);
        ExcelUtil.exportExcel(list, "免审核人员", BcDinernoreviewVo.class, response);
    }

    /**
     * 获取免审核人员详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("dinermanage:dinernoreview:query")
    @GetMapping("/{id}")
    public R<BcDinernoreviewVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcDinernoreviewService.queryById(id));
    }

    /**
     * 新增免审核人员
     */
    @SaCheckPermission("dinermanage:dinernoreview:add")
    @Log(title = "免审核人员", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcDinernoreviewBo bo) {
        return toAjax(bcDinernoreviewService.insertByBo(bo));
    }

    /**
     * 修改免审核人员
     */
    @SaCheckPermission("dinermanage:dinernoreview:edit")
    @Log(title = "免审核人员", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcDinernoreviewBo bo) {
        return toAjax(bcDinernoreviewService.updateByBo(bo));
    }

    /**
     * 删除免审核人员
     *
     * @param ids 主键串
     */
    @SaCheckPermission("dinermanage:dinernoreview:remove")
    @Log(title = "免审核人员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcDinernoreviewService.deleteWithValidByIds(List.of(ids), true));
    }
}

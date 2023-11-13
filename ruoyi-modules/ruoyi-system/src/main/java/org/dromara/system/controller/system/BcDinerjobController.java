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
import org.dromara.system.domain.bo.BcDinerjobBo;
import org.dromara.system.domain.vo.BcDinerjobVo;
import org.dromara.system.service.IBcDinerjobService;
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
 * 职务设置
 *
 * @author 周强
 * @date 2023-11-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinermanage/dinerjob")
public class BcDinerjobController extends BaseController {

    private final IBcDinerjobService bcDinerjobService;

    /**
     * 查询职务设置列表
     */
    @SaCheckPermission("dinermanage:dinerjob:list")
    @GetMapping("/list")
    public TableDataInfo<BcDinerjobVo> list(BcDinerjobBo bo, PageQuery pageQuery) {
        return bcDinerjobService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出职务设置列表
     */
    @SaCheckPermission("dinermanage:dinerjob:export")
    @Log(title = "职务设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinerjobBo bo, HttpServletResponse response) {
        List<BcDinerjobVo> list = bcDinerjobService.queryList(bo);
        ExcelUtil.exportExcel(list, "职务设置", BcDinerjobVo.class, response);
    }

    /**
     * 获取职务设置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("dinermanage:dinerjob:query")
    @GetMapping("/{id}")
    public R<BcDinerjobVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcDinerjobService.queryById(id));
    }

    /**
     * 新增职务设置
     */
    @SaCheckPermission("dinermanage:dinerjob:add")
    @Log(title = "职务设置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcDinerjobBo bo) {
        return toAjax(bcDinerjobService.insertByBo(bo));
    }

    /**
     * 修改职务设置
     */
    @SaCheckPermission("dinermanage:dinerjob:edit")
    @Log(title = "职务设置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcDinerjobBo bo) {
        return toAjax(bcDinerjobService.updateByBo(bo));
    }

    /**
     * 删除职务设置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("dinermanage:dinerjob:remove")
    @Log(title = "职务设置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcDinerjobService.deleteWithValidByIds(List.of(ids), true));
    }
}

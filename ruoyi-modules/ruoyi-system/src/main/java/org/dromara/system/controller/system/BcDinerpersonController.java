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
import org.dromara.system.domain.bo.BcDinerpersonBo;
import org.dromara.system.domain.vo.BcDinerpersonVo;
import org.dromara.system.service.IBcDinerpersonService;
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
 * 用餐人员信息
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinermanage/dinerperson")
public class BcDinerpersonController extends BaseController {

    private final IBcDinerpersonService bcDinerpersonService;

    /**
     * 查询用餐人员信息列表
     */
    @SaCheckPermission("dinermanage:dinerperson:list")
    @GetMapping("/list")
    public TableDataInfo<BcDinerpersonVo> list(BcDinerpersonBo bo, PageQuery pageQuery) {
        return bcDinerpersonService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出用餐人员信息列表
     */
    @SaCheckPermission("dinermanage:dinerperson:export")
    @Log(title = "用餐人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinerpersonBo bo, HttpServletResponse response) {
        List<BcDinerpersonVo> list = bcDinerpersonService.queryList(bo);
        ExcelUtil.exportExcel(list, "用餐人员信息", BcDinerpersonVo.class, response);
    }

    /**
     * 获取用餐人员信息详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("dinermanage:dinerperson:query")
    @GetMapping("/{id}")
    public R<BcDinerpersonVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcDinerpersonService.queryById(id));
    }

    /**
     * 新增用餐人员信息
     */
    @SaCheckPermission("dinermanage:dinerperson:add")
    @Log(title = "用餐人员信息", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcDinerpersonBo bo) {
        return toAjax(bcDinerpersonService.insertByBo(bo));
    }

    /**
     * 修改用餐人员信息
     */
    @SaCheckPermission("dinermanage:dinerperson:edit")
    @Log(title = "用餐人员信息", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcDinerpersonBo bo) {
        return toAjax(bcDinerpersonService.updateByBo(bo));
    }

    /**
     * 删除用餐人员信息
     *
     * @param ids 主键串
     */
    @SaCheckPermission("dinermanage:dinerperson:remove")
    @Log(title = "用餐人员信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcDinerpersonService.deleteWithValidByIds(List.of(ids), true));
    }
}

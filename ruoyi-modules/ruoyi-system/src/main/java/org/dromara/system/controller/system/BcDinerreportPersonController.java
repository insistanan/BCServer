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
import org.dromara.system.domain.bo.BcDinerreportPersonBo;
import org.dromara.system.domain.vo.BcDinerreportPersonVo;
import org.dromara.system.service.IBcDinerreportPersonService;
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
 * 未实际就餐统计
 *
 * @author 周强
 * @date 2023-11-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinerreport/dinerreportPerson")
public class BcDinerreportPersonController extends BaseController {

    private final IBcDinerreportPersonService bcDinerreportPersonService;

    /**
     * 查询未实际就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:list")
    @GetMapping("/list")
    public TableDataInfo<BcDinerreportPersonVo> list(BcDinerreportPersonBo bo, PageQuery pageQuery) {
        return bcDinerreportPersonService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出未实际就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:export")
    @Log(title = "未实际就餐统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinerreportPersonBo bo, HttpServletResponse response) {
        List<BcDinerreportPersonVo> list = bcDinerreportPersonService.queryList(bo);
        ExcelUtil.exportExcel(list, "未实际就餐统计", BcDinerreportPersonVo.class, response);
    }

    /**
     * 获取未实际就餐统计详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:query")
    @GetMapping("/{id}")
    public R<BcDinerreportPersonVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcDinerreportPersonService.queryById(id));
    }

    /**
     * 新增未实际就餐统计
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:add")
    @Log(title = "未实际就餐统计", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcDinerreportPersonBo bo) {
        return toAjax(bcDinerreportPersonService.insertByBo(bo));
    }

    /**
     * 修改未实际就餐统计
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:edit")
    @Log(title = "未实际就餐统计", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcDinerreportPersonBo bo) {
        return toAjax(bcDinerreportPersonService.updateByBo(bo));
    }

    /**
     * 删除未实际就餐统计
     *
     * @param ids 主键串
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:remove")
    @Log(title = "未实际就餐统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcDinerreportPersonService.deleteWithValidByIds(List.of(ids), true));
    }
}

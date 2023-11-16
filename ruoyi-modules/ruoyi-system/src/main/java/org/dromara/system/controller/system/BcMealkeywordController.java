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
import org.dromara.system.domain.vo.BcMealkeywordVo;
import org.dromara.system.domain.bo.BcMealkeywordBo;
import org.dromara.system.service.IBcMealkeywordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 关键词
 *
 * @author 周强
 * @date 2023-11-16
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealkeyword")
public class BcMealkeywordController extends BaseController {

    private final IBcMealkeywordService bcMealkeywordService;

    /**
     * 查询关键词列表
     */
    @SaCheckPermission("mealmanage:mealkeyword:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealkeywordVo> list(BcMealkeywordBo bo, PageQuery pageQuery) {
        return bcMealkeywordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出关键词列表
     */
    @SaCheckPermission("mealmanage:mealkeyword:export")
    @Log(title = "关键词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealkeywordBo bo, HttpServletResponse response) {
        List<BcMealkeywordVo> list = bcMealkeywordService.queryList(bo);
        ExcelUtil.exportExcel(list, "关键词", BcMealkeywordVo.class, response);
    }

    /**
     * 获取关键词详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealkeyword:query")
    @GetMapping("/{id}")
    public R<BcMealkeywordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealkeywordService.queryById(id));
    }

    /**
     * 新增关键词
     */
    @SaCheckPermission("mealmanage:mealkeyword:add")
    @Log(title = "关键词", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealkeywordBo bo) {
        return toAjax(bcMealkeywordService.insertByBo(bo));
    }

    /**
     * 修改关键词
     */
    @SaCheckPermission("mealmanage:mealkeyword:edit")
    @Log(title = "关键词", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealkeywordBo bo) {
        return toAjax(bcMealkeywordService.updateByBo(bo));
    }

    /**
     * 删除关键词
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealkeyword:remove")
    @Log(title = "关键词", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealkeywordService.deleteWithValidByIds(List.of(ids), true));
    }
}

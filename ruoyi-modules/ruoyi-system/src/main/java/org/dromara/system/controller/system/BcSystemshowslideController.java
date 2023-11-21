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
import org.dromara.system.domain.vo.BcSystemshowslideVo;
import org.dromara.system.domain.bo.BcSystemshowslideBo;
import org.dromara.system.service.IBcSystemshowslideService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 首页幻灯片
 *
 * @author 周强
 * @date 2023-11-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/systemshow/systemshowslide")
public class BcSystemshowslideController extends BaseController {

    private final IBcSystemshowslideService bcSystemshowslideService;

    /**
     * 查询首页幻灯片列表
     */
    @SaCheckPermission("systemshow:systemshowslide:list")
    @GetMapping("/list")
    public TableDataInfo<BcSystemshowslideVo> list(BcSystemshowslideBo bo, PageQuery pageQuery) {
        return bcSystemshowslideService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出首页幻灯片列表
     */
    @SaCheckPermission("systemshow:systemshowslide:export")
    @Log(title = "首页幻灯片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcSystemshowslideBo bo, HttpServletResponse response) {
        List<BcSystemshowslideVo> list = bcSystemshowslideService.queryList(bo);
        ExcelUtil.exportExcel(list, "首页幻灯片", BcSystemshowslideVo.class, response);
    }

    /**
     * 获取首页幻灯片详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("systemshow:systemshowslide:query")
    @GetMapping("/{id}")
    public R<BcSystemshowslideVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcSystemshowslideService.queryById(id));
    }

    /**
     * 新增首页幻灯片
     */
    @SaCheckPermission("systemshow:systemshowslide:add")
    @Log(title = "首页幻灯片", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcSystemshowslideBo bo) {
        return toAjax(bcSystemshowslideService.insertByBo(bo));
    }

    /**
     * 修改首页幻灯片
     */
    @SaCheckPermission("systemshow:systemshowslide:edit")
    @Log(title = "首页幻灯片", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcSystemshowslideBo bo) {
        return toAjax(bcSystemshowslideService.updateByBo(bo));
    }

    /**
     * 删除首页幻灯片
     *
     * @param ids 主键串
     */
    @SaCheckPermission("systemshow:systemshowslide:remove")
    @Log(title = "首页幻灯片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcSystemshowslideService.deleteWithValidByIds(List.of(ids), true));
    }
}

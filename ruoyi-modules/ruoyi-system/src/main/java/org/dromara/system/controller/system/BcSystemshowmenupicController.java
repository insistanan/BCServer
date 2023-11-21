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
import org.dromara.system.domain.vo.BcSystemshowmenupicVo;
import org.dromara.system.domain.bo.BcSystemshowmenupicBo;
import org.dromara.system.service.IBcSystemshowmenupicService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 菜谱图片
 *
 * @author 周强
 * @date 2023-11-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/systemshow/systemshowmenupic")
public class BcSystemshowmenupicController extends BaseController {

    private final IBcSystemshowmenupicService bcSystemshowmenupicService;

    /**
     * 查询菜谱图片列表
     */
    @SaCheckPermission("systemshow:systemshowmenupic:list")
    @GetMapping("/list")
    public TableDataInfo<BcSystemshowmenupicVo> list(BcSystemshowmenupicBo bo, PageQuery pageQuery) {
        return bcSystemshowmenupicService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出菜谱图片列表
     */
    @SaCheckPermission("systemshow:systemshowmenupic:export")
    @Log(title = "菜谱图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcSystemshowmenupicBo bo, HttpServletResponse response) {
        List<BcSystemshowmenupicVo> list = bcSystemshowmenupicService.queryList(bo);
        ExcelUtil.exportExcel(list, "菜谱图片", BcSystemshowmenupicVo.class, response);
    }

    /**
     * 获取菜谱图片详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("systemshow:systemshowmenupic:query")
    @GetMapping("/{id}")
    public R<BcSystemshowmenupicVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcSystemshowmenupicService.queryById(id));
    }

    /**
     * 新增菜谱图片
     */
    @SaCheckPermission("systemshow:systemshowmenupic:add")
    @Log(title = "菜谱图片", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcSystemshowmenupicBo bo) {
        return toAjax(bcSystemshowmenupicService.insertByBo(bo));
    }

    /**
     * 修改菜谱图片
     */
    @SaCheckPermission("systemshow:systemshowmenupic:edit")
    @Log(title = "菜谱图片", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcSystemshowmenupicBo bo) {
        return toAjax(bcSystemshowmenupicService.updateByBo(bo));
    }

    /**
     * 删除菜谱图片
     *
     * @param ids 主键串
     */
    @SaCheckPermission("systemshow:systemshowmenupic:remove")
    @Log(title = "菜谱图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcSystemshowmenupicService.deleteWithValidByIds(List.of(ids), true));
    }
}

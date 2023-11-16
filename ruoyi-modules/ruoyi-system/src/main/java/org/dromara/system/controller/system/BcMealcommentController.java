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
import org.dromara.system.domain.bo.BcMealcommentBo;
import org.dromara.system.domain.vo.BcMealcommentVo;
import org.dromara.system.service.IBcMealcommentService;
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
 * 评论
 *
 * @author 周强
 * @date 2023-11-16
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/mealcomment")
public class BcMealcommentController extends BaseController {

    private final IBcMealcommentService bcMealcommentService;

    /**
     * 查询评论列表
     */
    @SaCheckPermission("mealmanage:mealcomment:list")
    @GetMapping("/list")
    public TableDataInfo<BcMealcommentVo> list(BcMealcommentBo bo, PageQuery pageQuery) {
        return bcMealcommentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出评论列表
     */
    @SaCheckPermission("mealmanage:mealcomment:export")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcMealcommentBo bo, HttpServletResponse response) {
        List<BcMealcommentVo> list = bcMealcommentService.queryList(bo);
        ExcelUtil.exportExcel(list, "评论", BcMealcommentVo.class, response);
    }

    /**
     * 获取评论详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:mealcomment:query")
    @GetMapping("/{id}")
    public R<BcMealcommentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcMealcommentService.queryById(id));
    }

    /**
     * 新增评论
     */
    @SaCheckPermission("mealmanage:mealcomment:add")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcMealcommentBo bo) {
        return toAjax(bcMealcommentService.insertByBo(bo));
    }

    /**
     * 修改评论
     */
    @SaCheckPermission("mealmanage:mealcomment:edit")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcMealcommentBo bo) {
        return toAjax(bcMealcommentService.updateByBo(bo));
    }

    /**
     * 删除评论
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:mealcomment:remove")
    @Log(title = "评论", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcMealcommentService.deleteWithValidByIds(List.of(ids), true));
    }
}

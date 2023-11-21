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
import org.dromara.system.domain.vo.BcSystemshownoticeVo;
import org.dromara.system.domain.bo.BcSystemshownoticeBo;
import org.dromara.system.service.IBcSystemshownoticeService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 公告
 *
 * @author 周强
 * @date 2023-11-19
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/systemshow/systemshownotice")
public class BcSystemshownoticeController extends BaseController {

    private final IBcSystemshownoticeService bcSystemshownoticeService;

    /**
     * 查询公告列表
     */
    @SaCheckPermission("systemshow:systemshownotice:list")
    @GetMapping("/list")
    public TableDataInfo<BcSystemshownoticeVo> list(BcSystemshownoticeBo bo, PageQuery pageQuery) {
        return bcSystemshownoticeService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出公告列表
     */
    @SaCheckPermission("systemshow:systemshownotice:export")
    @Log(title = "公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcSystemshownoticeBo bo, HttpServletResponse response) {
        List<BcSystemshownoticeVo> list = bcSystemshownoticeService.queryList(bo);
        ExcelUtil.exportExcel(list, "公告", BcSystemshownoticeVo.class, response);
    }

    /**
     * 获取公告详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("systemshow:systemshownotice:query")
    @GetMapping("/{id}")
    public R<BcSystemshownoticeVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcSystemshownoticeService.queryById(id));
    }

    /**
     * 新增公告
     */
    @SaCheckPermission("systemshow:systemshownotice:add")
    @Log(title = "公告", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcSystemshownoticeBo bo) {
        return toAjax(bcSystemshownoticeService.insertByBo(bo));
    }

    /**
     * 修改公告
     */
    @SaCheckPermission("systemshow:systemshownotice:edit")
    @Log(title = "公告", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcSystemshownoticeBo bo) {
        return toAjax(bcSystemshownoticeService.updateByBo(bo));
    }

    /**
     * 删除公告
     *
     * @param ids 主键串
     */
    @SaCheckPermission("systemshow:systemshownotice:remove")
    @Log(title = "公告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcSystemshownoticeService.deleteWithValidByIds(List.of(ids), true));
    }
}

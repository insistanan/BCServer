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
import org.dromara.system.domain.bo.BcOrderdetailBo;
import org.dromara.system.domain.vo.BcOrderdetailVo;
import org.dromara.system.service.IBcOrderdetailService;
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
 * 订单明细
 *
 * @author 周强
 * @date 2023-11-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mealmanage/orderdetail")
public class BcOrderdetailController extends BaseController {

    private final IBcOrderdetailService bcOrderdetailService;

    /**
     * 查询订单明细列表
     */
    @SaCheckPermission("mealmanage:orderdetail:list")
    @GetMapping("/list")
    public TableDataInfo<BcOrderdetailVo> list(BcOrderdetailBo bo, PageQuery pageQuery) {
        return bcOrderdetailService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出订单明细列表
     */
    @SaCheckPermission("mealmanage:orderdetail:export")
    @Log(title = "订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcOrderdetailBo bo, HttpServletResponse response) {
        List<BcOrderdetailVo> list = bcOrderdetailService.queryList(bo);
        ExcelUtil.exportExcel(list, "订单明细", BcOrderdetailVo.class, response);
    }

    /**
     * 获取订单明细详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("mealmanage:orderdetail:query")
    @GetMapping("/{id}")
    public R<BcOrderdetailVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcOrderdetailService.queryById(id));
    }

    /**
     * 新增订单明细
     */
    @SaCheckPermission("mealmanage:orderdetail:add")
    @Log(title = "订单明细", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcOrderdetailBo bo) {
        return toAjax(bcOrderdetailService.insertByBo(bo));
    }

    /**
     * 修改订单明细
     */
    @SaCheckPermission("mealmanage:orderdetail:edit")
    @Log(title = "订单明细", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcOrderdetailBo bo) {
        return toAjax(bcOrderdetailService.updateByBo(bo));
    }

    /**
     * 删除订单明细
     *
     * @param ids 主键串
     */
    @SaCheckPermission("mealmanage:orderdetail:remove")
    @Log(title = "订单明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcOrderdetailService.deleteWithValidByIds(List.of(ids), true));
    }
}

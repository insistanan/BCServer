package org.dromara.system.controller.api;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.vo.BcDinerpersonVo;
import org.dromara.system.service.IBcDinerpersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用餐人员信息
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dinerperson")
public class ApiDinerreportPersonController extends BaseController {

    private final IBcDinerpersonService bcDinerpersonService;


    /**
     * 获取用餐人员信息详细信息
     *
     * @param id 主键
     */
    @GetMapping("/{id}")
    public R<BcDinerpersonVo> getInfo(@NotNull(message = "主键不能为空")
                                      @PathVariable Long id) {
        return R.ok(bcDinerpersonService.queryById(id));
    }

}

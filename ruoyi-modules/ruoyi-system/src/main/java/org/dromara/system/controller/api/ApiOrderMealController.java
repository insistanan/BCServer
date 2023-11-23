package org.dromara.system.controller.api;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.vo.BcDinerpersonVo;
import org.dromara.system.service.IBcDinerpersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/ordermeal")
public class ApiOrderMealController extends BaseController {

    private final IBcDinerpersonService bcDinerpersonService;


    /**
     * 获取用餐人员信息详细信息
     *
     * @param id 主键
     */
    @PostMapping("/{id}")
    public R<BcDinerpersonVo> getInfo(@NotNull(message = "主键不能为空")
                                      @PathVariable Long id) {
        return R.ok(bcDinerpersonService.queryById(id));
    }

    @PostMapping ("/queryJoinRestaurant/{id}")
    public R<BcDinerpersonVo> queryJoinRestaurant(@NotNull(message = "主键不能为空")
                                      @PathVariable Long id) {
        return R.ok(bcDinerpersonService.queryById(id));
    }

    @PostMapping ("/queryAddress/{id}")
    public R<BcDinerpersonVo> queryAddress(@NotNull(message = "主键不能为空")
                                                  @PathVariable Long id) {
        return R.ok(bcDinerpersonService.queryById(id));
    }

    @PostMapping ("/queryMealRecord/{id}")
    public R<BcDinerpersonVo> queryMealRecord(@NotNull(message = "主键不能为空")
                                           @PathVariable Long id) {
        return R.ok(bcDinerpersonService.queryById(id));
    }

}

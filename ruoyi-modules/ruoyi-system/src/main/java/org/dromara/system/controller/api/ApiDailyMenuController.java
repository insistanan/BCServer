package org.dromara.system.controller.api;

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

import java.util.Date;

/**
 * 查询今日菜单信息
 *
 * @author Lion Li
 * @date 2023-11-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dailymenu")
public class ApiDailyMenuController extends BaseController {

    private final IBcDinerpersonService bcDinerpersonService;



    @PostMapping ("/queryDailymenu")
    public R<BcDinerpersonVo> queryDailymenu(@PathVariable Date queryDate, String tenantId) {
        return null;
//        return R.ok(bcDinerpersonService.queryById(id));
    }


}

package org.dromara.system.controller.api;

import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.tenant.helper.TenantHelper;
import org.dromara.system.service.impl.SysConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 获取当前租户是否开启扫码核销功能
 * @author insis
 * @date 2023/12/07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/qraccount")
public class ApiGetQrAccountFlagController {
    @Autowired
    private SysConfigServiceImpl sysConfigService;

    @GetMapping("/getFlag")
    public R<Boolean> getGetQrAccountFlag(){

        return R.ok(sysConfigService.getQrAccountFlag(TenantHelper.getTenantId()));
    }
}

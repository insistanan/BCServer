package org.dromara.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.bo.BcDinerreportServetimeBo;
import org.dromara.system.domain.vo.BcDinerreportServetimeVo;
import org.dromara.system.service.IBcDinerreportServetimeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 时段就餐统计
 *
 * @author 周强
 * @date 2023-11-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinerreport/dinerreportServetime")
public class BcDinerreportServetimeController extends BaseController {

    private final IBcDinerreportServetimeService bcDinerreportServetimeService;

    /**
     * 查询时段就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportServetime:list")
    @GetMapping("/report")
    public Map<String, Map<String, Map<String, Object>>> report(BcDinerreportServetimeBo bo) {
        Map<String, Map<String, Map<String, Object>>> result = new LinkedHashMap<>();
        List<BcDinerreportServetimeVo> list = bcDinerreportServetimeService.queryDinerreportServetime(bo);

        for (BcDinerreportServetimeVo vo : list) {
            String deptName = vo.getDeptName();
            String servetimeName = vo.getServetimeName();

            result.putIfAbsent(deptName, new LinkedHashMap<>());

            Map<String, Map<String, Object>> servetimeMap = result.get(deptName);
            servetimeMap.putIfAbsent(servetimeName, new LinkedHashMap<>());

            Map<String, Object> dataMap = servetimeMap.get(servetimeName);
            dataMap.put("dinertotalnum", vo.getDinertotalnum());
            dataMap.put("usedinernum", vo.getUsedinernum());
            dataMap.put("unusedinernum", vo.getUnusedinernum());
        }

        return result;
    }
    private Map<String, Object> createHeader(String columnName, String... subColumns) {
        return Map.of("columnName", columnName, "subColumns", Arrays.asList(subColumns));
    }

    /**
     * 导出时段就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportServetime:export")
    @Log(title = "时段就餐统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinerreportServetimeBo bo, HttpServletResponse response) {
        List<BcDinerreportServetimeVo> list = bcDinerreportServetimeService.queryList(bo);
        ExcelUtil.exportExcel(list, "时段就餐统计", BcDinerreportServetimeVo.class, response);
    }
}

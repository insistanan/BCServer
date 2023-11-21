package org.dromara.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
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
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public Map<String, Object> report(BcDinerreportServetimeBo bo) {
        Map<String, Object> result = new LinkedHashMap<>();
        List<BcDinerreportServetimeVo> dataList = bcDinerreportServetimeService.queryDinerreportServetime(bo);

        // 部门数据统计
        Map<String, DeptData> deptDataMap = new LinkedHashMap<>();
        // 存储就餐时段名称
        Set<String> servetimeNames = new HashSet<>();

        for (BcDinerreportServetimeVo vo : dataList) {
            String deptName = vo.getDeptName();
            String servetimeName = vo.getServetimeName();
            servetimeNames.add(servetimeName);

            DeptData deptData = deptDataMap.computeIfAbsent(deptName, k -> new DeptData());
            deptData.setDeptName(deptName);
            deptData.setDinertotalnum(deptData.getDinertotalnum() + vo.getDinertotalnum());
            deptData.setUsedinernum(deptData.getUsedinernum() + vo.getUsedinernum());
            deptData.setUnusedinernum(deptData.getUnusedinernum() + vo.getUnusedinernum());
        }

        // 将 DeptData 转换为 Map
        JSONArray tableDataArray = new JSONArray();
        for (DeptData deptData : deptDataMap.values()) {
            JSONObject tableData = new JSONObject();
            tableData.put("deptName", deptData.getDeptName());
            tableData.put("dinertotalnum", String.valueOf(deptData.getDinertotalnum()));
            tableData.put("usedinernum", String.valueOf(deptData.getUsedinernum()));
            tableData.put("unusedinernum", String.valueOf(deptData.getUnusedinernum()));
            tableDataArray.add(tableData);
        }

        // 动态生成 servetimeNameMap
        JSONObject servetimeNameClounms = new JSONObject();
        for (String servetime : servetimeNames) {
            JSONObject servetimeName = new JSONObject();
            JSONObject clounmName = new JSONObject();
            clounmName.put("dinertotalnum", "已报餐数");
            clounmName.put("usedinernum", "实际就餐数");
            clounmName.put("unusedinernum", "未实际就餐数");
            servetimeName.put(servetime, clounmName);
            servetimeNameClounms.putAll(servetimeName);
        }


        // 将最终结果添加到result
        result.put("tableData", tableDataArray.toString());
        result.put("servetimeNameMap", servetimeNameClounms.toString());

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

    public class ResultData {
        private List<DeptData> tableData;
        private Map<String, Map<String, String>> servetimeNameMap;

        public List<DeptData> getTableData() {
            return tableData;
        }

        public void setTableData(List<DeptData> tableData) {
            this.tableData = tableData;
        }

        public Map<String, Map<String, String>> getServetimeNameMap() {
            return servetimeNameMap;
        }

        public void setServetimeNameMap(Map<String, Map<String, String>> servetimeNameMap) {
            this.servetimeNameMap = servetimeNameMap;
        }
    }

    public class DeptData {
        private String deptName;
        private int dinertotalnum;
        private int usedinernum;
        private int unusedinernum;

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public int getDinertotalnum() {
            return dinertotalnum;
        }

        public void setDinertotalnum(int dinertotalnum) {
            this.dinertotalnum = dinertotalnum;
        }

        public int getUsedinernum() {
            return usedinernum;
        }

        public void setUsedinernum(int usedinernum) {
            this.usedinernum = usedinernum;
        }

        public int getUnusedinernum() {
            return unusedinernum;
        }

        public void setUnusedinernum(int unusedinernum) {
            this.unusedinernum = unusedinernum;
        }
    }
}

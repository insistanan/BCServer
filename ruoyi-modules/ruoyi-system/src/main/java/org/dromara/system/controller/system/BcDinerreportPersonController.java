package org.dromara.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
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
import org.dromara.system.domain.bo.BcDinerreportPersonBo;
import org.dromara.system.domain.vo.BcDinerreportPersonVo;
import org.dromara.system.service.IBcDinerreportPersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 未实际就餐统计
 *
 * @author 周强
 * @date 2023-11-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/dinerreport/dinerreportPerson")
public class BcDinerreportPersonController extends BaseController {

    private final IBcDinerreportPersonService bcDinerreportPersonService;

    /**
     * 查询时段就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportServetime:list")
    @GetMapping("/report")
    public Map<String, Object> report(BcDinerreportPersonBo bo) {
        Map<String, Object> result = new LinkedHashMap<>();
        List<BcDinerreportPersonVo> dataList = bcDinerreportPersonService.queryDinerreportPerson(bo);


        // 存储就餐时段名称
        Set<String> servetimeNames = new HashSet<>();
        // 存储每个唯一顾客总的未用餐数量
        HashMap<String, Integer> unusenum = new HashMap<>();
        for (BcDinerreportPersonVo vo : dataList) {
            String key = vo.getDeptName() + "|" + vo.getJobName() + "|" + vo.getCustomerName() +
                vo.getServetimeName();
            if (null == unusenum.get(key)){
                unusenum.put(key, vo.getUnusenum());
            }else {
                unusenum.put(key, vo.getUnusenum() + unusenum.get(key));
            }
            servetimeNames.add(vo.getServetimeName());
        }

        for (BcDinerreportPersonVo vo : dataList) {
            String key = vo.getDeptName() + "|" + vo.getJobName() + "|" + vo.getCustomerName() +
                vo.getServetimeName();
            if (null == unusenum.get(key)){
                unusenum.put(key, vo.getUnusenum());
            }else {
                unusenum.put(key, vo.getUnusenum() + unusenum.get(key));
            }
            servetimeNames.add(vo.getServetimeName());
        }

        // 部门数据统计
        Map<String, DeptData> deptDataMap = new LinkedHashMap<>();
        for (BcDinerreportPersonVo vo : dataList) {
            String deptName = vo.getDeptName();
            String servetimeName = vo.getServetimeName();
            servetimeNames.add(servetimeName);

            DeptData deptData = deptDataMap.computeIfAbsent(deptName, k -> new DeptData());
            deptData.setDeptName(deptName);
            deptData.setSingleunusenum(vo.getSingleunusenum());
        }

        // 将 DeptData 转换为 Map
        JSONArray tableDataArray = new JSONArray();
        for (DeptData deptData : deptDataMap.values()) {
            JSONObject tableData = new JSONObject();
            tableData.put("deptName", deptData.getDeptName());
            tableData.put("unusedinernum", String.valueOf(deptData.getSingleunusenum()));
            tableDataArray.add(tableData);
        }

        // 动态生成 servetimeNameMap
        JSONObject servetimeNameClounms = new JSONObject();
        int i = 0;
        for (String servetime : servetimeNames) {
            JSONObject servetimeName = new JSONObject();
            JSONObject clounmName = new JSONObject();
            clounmName.put("servetime" + i, servetime);
            servetimeName.put(servetime, clounmName);
            servetimeNameClounms.putAll(servetimeName);
            i++;
        }


        // 将最终结果添加到result
        result.put("tableData", tableDataArray.toString());
        result.put("servetimeNameMap", servetimeNameClounms.toString());

        return result;
    }

    /**
     * 查询未实际就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:list")
    @GetMapping("/list")
    public TableDataInfo<BcDinerreportPersonVo> list(BcDinerreportPersonBo bo, PageQuery pageQuery) {
        return bcDinerreportPersonService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出未实际就餐统计列表
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:export")
    @Log(title = "未实际就餐统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BcDinerreportPersonBo bo, HttpServletResponse response) {
        List<BcDinerreportPersonVo> list = bcDinerreportPersonService.queryList(bo);
        ExcelUtil.exportExcel(list, "未实际就餐统计", BcDinerreportPersonVo.class, response);
    }

    /**
     * 获取未实际就餐统计详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:query")
    @GetMapping("/{id}")
    public R<BcDinerreportPersonVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(bcDinerreportPersonService.queryById(id));
    }

    /**
     * 新增未实际就餐统计
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:add")
    @Log(title = "未实际就餐统计", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BcDinerreportPersonBo bo) {
        return toAjax(bcDinerreportPersonService.insertByBo(bo));
    }

    /**
     * 修改未实际就餐统计
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:edit")
    @Log(title = "未实际就餐统计", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BcDinerreportPersonBo bo) {
        return toAjax(bcDinerreportPersonService.updateByBo(bo));
    }

    /**
     * 删除未实际就餐统计
     *
     * @param ids 主键串
     */
    @SaCheckPermission("dinerreport:dinerreportPerson:remove")
    @Log(title = "未实际就餐统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(bcDinerreportPersonService.deleteWithValidByIds(List.of(ids), true));
    }

    public class DeptData {
        private String deptName;
        private int customerName;
        private int jobName;
        private int singleunusenum;

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public int getCustomerName() {
            return customerName;
        }

        public void setCustomerName(int customerName) {
            this.customerName = customerName;
        }

        public int getJobName() {
            return jobName;
        }

        public void setJobName(int jobName) {
            this.jobName = jobName;
        }

        public int getSingleunusenum() {
            return singleunusenum;
        }

        public void setSingleunusenum(int singleunusenum) {
            this.singleunusenum = singleunusenum;
        }
    }
}

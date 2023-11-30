package org.dromara.system.controller.api;

import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.api.DailyMenu;
import org.dromara.system.domain.api.DailyMenuDetail;
import org.dromara.system.domain.api.DailyMenuGrouding;
import org.dromara.system.domain.bo.BcMealdailymenuBo;
import org.dromara.system.domain.vo.BcMealdailymenuVo;
import org.dromara.system.service.IBcMealdailymenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    private final IBcMealdailymenuService bcMealdailymenuService;

    @PostMapping ("/queryDailymenu")
    public R<DailyMenu> queryDailymenu(@PathVariable Date queryDate, String tenantId) {
        DailyMenu dailyMenu = new DailyMenu();
        BcMealdailymenuBo bo = new BcMealdailymenuBo();
        bo.setSearchTime(queryDate);
        List<BcMealdailymenuVo> bcMealdailymenuVoList = bcMealdailymenuService.queryList(bo);

        int dayOfWeek = DateUtils.getDayOfWeek(queryDate);

        HashMap<String, DailyMenuGrouding> dailyMenuGroudingHashMap = new HashMap<>();
        for (BcMealdailymenuVo bcMealdailymenuVo : bcMealdailymenuVoList){
            if (!bcMealdailymenuVo.getFoodServerday().contains(dayOfWeek + "")){
                continue;
            }
            if (null == dailyMenuGroudingHashMap.get(bcMealdailymenuVo.getFoodGrounding())){
                DailyMenuGrouding dailyMenuGrouding = new DailyMenuGrouding();
                dailyMenuGrouding.setServerLimit(bcMealdailymenuVo.getServetimeNum());
                dailyMenuGrouding.setServerTimeName(bcMealdailymenuVo.getFoodGrounding());
                dailyMenuGrouding.setServetimeRepotrendtime(bcMealdailymenuVo.getServetimeRepotrendtime());
                List<DailyMenuDetail> dailyMenuDetailList = new ArrayList<>();
                DailyMenuDetail dailyMenuDetail = new DailyMenuDetail();
                dailyMenuDetail.setPrice(bcMealdailymenuVo.getFoodPrice().floatValue());
                dailyMenuDetail.setFoodName(bcMealdailymenuVo.getFoodName());
                dailyMenuDetail.setStockLimit(bcMealdailymenuVo.getLimitNum());
                dailyMenuDetailList.add(dailyMenuDetail);
                dailyMenuGrouding.setDailyMenuDetailList(dailyMenuDetailList);
                dailyMenuGroudingHashMap.put(bcMealdailymenuVo.getFoodGrounding(), dailyMenuGrouding);
            }else {
                List<DailyMenuDetail> dailyMenuDetailList = dailyMenuGroudingHashMap.get(bcMealdailymenuVo.getFoodGrounding()).getDailyMenuDetailList();
                DailyMenuDetail dailyMenuDetail = new DailyMenuDetail();
                dailyMenuDetail.setPrice(bcMealdailymenuVo.getFoodPrice().floatValue());
                dailyMenuDetail.setFoodName(bcMealdailymenuVo.getFoodName());
                dailyMenuDetail.setStockLimit(bcMealdailymenuVo.getLimitNum());
                dailyMenuDetailList.add(dailyMenuDetail);
            }
        }
        return R.ok(dailyMenu);
    }


}

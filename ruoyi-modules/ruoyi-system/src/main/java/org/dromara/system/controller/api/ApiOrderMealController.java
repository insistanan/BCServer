package org.dromara.system.controller.api;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.bo.BcMealdetailBo;
import org.dromara.system.domain.bo.BcOrderdetailBo;
import org.dromara.system.domain.vo.ApiOrderMealVo;
import org.dromara.system.domain.vo.BcDinerpersonVo;
import org.dromara.system.domain.vo.BcMealfoodsVo;
import org.dromara.system.service.IBcDinerpersonService;
import org.dromara.system.service.IBcMealdetailService;
import org.dromara.system.service.IBcMealfoodsService;
import org.dromara.system.service.IBcOrderdetailService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 订餐相关
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

    private final IBcMealfoodsService bcMealfoodsService;
    private final IBcMealdetailService bcMealdetailService;
    private final IBcOrderdetailService bcOrderdetailService;

    @PostMapping("/orderMeal")
    public R<BcDinerpersonVo> orderMeal(@RequestBody ApiOrderMealVo orderMealVo) {
        BcMealdetailBo bcMealdetailBo = new BcMealdetailBo();
        List<BcOrderdetailBo> orderdetailList = new ArrayList<>();
        try{
            bcMealdetailBo.setFoodGrounding(orderMealVo.getFoodGrounding());
            bcMealdetailBo.setFoodTypeid(orderMealVo.getFoodTypeid());
            bcMealdetailBo.setSumPrice(BigDecimal.ZERO);
            bcMealdetailBo.setDinnerTime(orderMealVo.getDinnerTime());
            bcMealdetailBo.setDinnerStatus("0");
            bcMealdetailBo.setBcTime(orderMealVo.getBcTime());
            //处理订单人员信息
            BcDinerpersonVo bcDinerpersonVo = bcDinerpersonService.queryById(orderMealVo.getPersonId());
            bcMealdetailBo.setPersonId(bcDinerpersonVo.getId());
            bcMealdetailBo.setCustomerName(bcDinerpersonVo.getPersonName());
            bcMealdetailBo.setCustomerPhone(bcDinerpersonVo.getPersonTel());
            bcMealdetailBo.setDeptId(bcDinerpersonVo.getPersonDinerdeptid());
            bcMealdetailBo.setJobId(bcDinerpersonVo.getPersonDinerjobid());
            JSONArray orderDetail = new JSONArray(orderMealVo.getOrderDetail());
            //解析orderDetail，这个是一个json数组字符串，格式为[{"foodId":"123", "num":"2"},{"foodId":"234", "num":"1"}]
            for (JSONObject jsonObject : orderDetail.jsonIter()){
                BcOrderdetailBo orderdetailBo = new BcOrderdetailBo();
                orderdetailBo.setDetailId(bcMealdetailBo.getId());
                orderdetailBo.setFoodId(jsonObject.getLong("foodId"));
                orderdetailBo.setFoodNumber(jsonObject.getInt("num"));
                orderdetailBo.setFoodGrounding(orderMealVo.getFoodGrounding());
                BcMealfoodsVo bcMealfoods = bcMealfoodsService.queryById(jsonObject.getLong("foodId"));
                bcMealdetailBo.setSumPrice(bcMealdetailBo.getSumPrice().add(new BigDecimal(bcMealfoods.getFoodPrice())));
                orderdetailList.add(orderdetailBo);
            }
            bcMealdetailService.insertByBo(bcMealdetailBo);
            for (BcOrderdetailBo bo : orderdetailList){
                bo.setDetailId(bcMealdetailBo.getId());
                bcOrderdetailService.insertByBo(bo);
            }
        }catch (Exception e){
            return R.fail("订餐失败！");
        }
        return R.ok();
    }


}

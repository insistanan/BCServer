package org.dromara.system.controller.api;

import cn.hutool.json.JSONArray;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.bo.BcMealdetailBo;
import org.dromara.system.domain.bo.BcOrderdetailBo;
import org.dromara.system.domain.vo.ApiOrderMealVo;
import org.dromara.system.domain.vo.BcDinerpersonVo;
import org.dromara.system.service.IBcDinerpersonService;
import org.dromara.system.service.IBcMealdetailService;
import org.dromara.system.service.IBcMealfoodsService;
import org.dromara.system.service.IBcOrderdetailService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    private final IBcMealfoodsService bcMealfoodsService;
    private final IBcMealdetailService bcMealdetailService;
    private final IBcOrderdetailService bcOrderdetailService;

    @PostMapping("/orderMeal")
    public R<BcDinerpersonVo> orderMeal(@RequestBody ApiOrderMealVo orderMealVo) {
        BcMealdetailBo bcMealdetailBo = new BcMealdetailBo();
        List<BcOrderdetailBo> orderdetailList = new ArrayList<>();
        //处理订单人员信息
        bcDinerpersonService.queryById(orderMealVo.getPersonId());

        JSONArray orderDetail = new JSONArray(orderMealVo.getOrderDetail());
        //解析orderDetail，这个是一个json数组字符串，格式为[{"foodId":"123", "num":"2"},{"foodId":"234", "num":"1"}]
//        for (){
//        BcOrderdetailBo orderdetailBo = new BcOrderdetailBo();
//        orderdetailBo.setDetailId(bcMealdetailBo.getId());
//        orderdetailList.add(orderdetailBo);
            //查询点餐人员数据
//            bcMealfoodsService.queryById();
//        }
        for (BcOrderdetailBo bo : orderdetailList){
            bcOrderdetailService.insertByBo(bo);
        }
        if (bcMealdetailService.insertByBo(bcMealdetailBo)){
            return R.ok();
        }else {
            return R.fail("预定菜品失败！");
        }

    }


}

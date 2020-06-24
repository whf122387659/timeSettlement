package com.dbb.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dbb.entity.Account;
import com.dbb.entity.Price;
import com.dbb.service.AccountService;
import com.dbb.service.PriceService;
import com.dbb.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    private PriceService priceService;

    @RequestMapping("/test")
    public void test(){
        float x = (float) 1.02;
        String nowtime = "1586247741";
        Price price = priceService.selectPriceByMerchantId(1207);
        String timeprice = price.getTimeprice();
        JSONArray tpArr = JSONArray.parseArray(timeprice);
        float cost = 0;
        for (Object tp:tpArr) {
            JSONObject jo = (JSONObject) tp;
            String [] timeSection = jo.get("time").toString().split("-");
            float p = Float.parseFloat(jo.get("price").toString());
            String startTime = timeSection[0].trim();
            String endTime = timeSection[1].trim();
            boolean inDate = DataUtil.isInDate(nowtime, startTime, endTime);
            if (inDate){
                cost = DataUtil.mul(x,p);
                break;
            }
        }
        System.out.println("================================================");
        System.out.println("=================================================");
        System.out.println(cost);
    }
}

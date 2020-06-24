package com.dbb.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dbb.entity.*;
import com.dbb.service.*;
import com.dbb.util.ApplicationCotextHelper;
import com.dbb.util.DataUtil;
import com.dbb.util.GatewayUtil;

import java.util.List;
import java.util.TimerTask;

/**
 * 执行内容
 * @author admin_Hzw
 *
 */
public class  Task extends TimerTask {
    private static ApplicationCotextHelper cotextHelper;
    public void run() {
        AccountService accountService = cotextHelper.popBean(AccountService.class);
        MerchantService merchantService = cotextHelper.popBean(MerchantService.class);
        PriceService priceService = cotextHelper.popBean(PriceService.class);
        EleUsageService eleUsageService = cotextHelper.popBean(EleUsageService.class);
        WaterUsageService waterUsageService = cotextHelper.popBean(WaterUsageService.class);
        try {
            if (accountService != null) {
                List<Account> accountList = accountService.selectAllAccount();
                for (Account account : accountList) {
                    Price price = priceService.selectPriceByMerchantId(account.getMerchantid());
                    //电表
                    if (account.getPowertype() == 0||account.getPowertype() == 3) {
                        //根据账户表记编，取接口用电量数据
                        JSONObject jsonMain = GatewayUtil.get_latest(account.getCollectors(), "ImpEp");
                        JSONObject data = (JSONObject) ((JSONObject) JSONObject.parse(jsonMain.get("data").toString())).get(account.getCollectors());
                        float now_reading = Float.parseFloat((data.get("ImpEp").toString()));
                        String settleTime = data.get("_tm").toString();
                        float before_reading = account.getNowreading();
                        //
                        ElecUsage timeUsage = new ElecUsage();
                        timeUsage.setMerchantid(account.getMerchantid());
                        float cost = 0;
                        timeUsage.setNowreading(now_reading);
                        timeUsage.setAllusage(DataUtil.add(now_reading, -before_reading));
                        if (price != null) {
                            //判断是统一计费还是分时计费
                            if (price.getType() == 1) {
                                String timeprice = price.getTimeprice();
                                JSONArray tpArr = JSONArray.parseArray(timeprice);
                                for (Object tp : tpArr) {
                                    JSONObject jo = (JSONObject) tp;
                                    String[] timeSection = jo.get("time").toString().split("-");
                                    float p = Float.parseFloat(jo.get("price").toString());
                                    String startTime = timeSection[0].trim();
                                    String endTime = timeSection[1].trim();
                                    boolean inDate = DataUtil.isInDate(settleTime, startTime, endTime);
                                    if (inDate) {
                                        String timeName = jo.get("priceTypeName").toString();
                                        cost = DataUtil.mul(timeUsage.getAllusage(), p);
                                     if ("tip".equals(timeName)) {
                                            timeUsage.setTipusage(timeUsage.getAllusage());
                                            timeUsage.setCost(cost);
                                            timeUsage.setTipcost(cost);
                                        } else if ("peak".equals(timeName)) {
                                            timeUsage.setPeakusage(timeUsage.getAllusage());
                                            timeUsage.setCost(cost);
                                            timeUsage.setPeakcost(cost);
                                        } else if ("valley".equals(timeName)) {
                                            timeUsage.setValleyusage(timeUsage.getAllusage());
                                            timeUsage.setCost(cost);
                                            timeUsage.setValleycost(cost);
                                        } else if ("flat".equals(timeName)) {
                                            timeUsage.setFlatusage(timeUsage.getAllusage());
                                            timeUsage.setCost(cost);
                                            timeUsage.setFlatcost(cost);
                                        }
                                        break;
                                    }
                                }
                            } else {
                                cost = DataUtil.mul(timeUsage.getAllusage(), Float.parseFloat(price.getUnifyprice()));
                                timeUsage.setCost(cost);
                            }
                        } else {
                            cost = DataUtil.mul(timeUsage.getAllusage(), 1);
                            timeUsage.setCost(cost);
                        }
                        if (account.getPowertype() == 3){
                            ElecUsage timeUsage2 = new ElecUsage();
                            int count = accountService.selectCount(account.getCollectors());
                            cost = DataUtil.divide(cost, count);
                            timeUsage2.setMerchantid(account.getMerchantid());
                            timeUsage2.setSharecost(cost);
                            timeUsage2.setShareusage(timeUsage.getAllusage());
                            timeUsage2.setSettletime(Integer.parseInt(settleTime));
                            eleUsageService.addTodayUsage(timeUsage2);
                        }else {
                            timeUsage.setSettletime(Integer.parseInt(settleTime));
                            eleUsageService.addTodayUsage(timeUsage);
                        }

                        Merchant merchant = merchantService.selectMerchantById(account.getMerchantid() + "");
                        merchant.setBalance(DataUtil.add(merchant.getBalance(), -cost));
                        merchantService.updateBalance(merchant);
                        account.setNowreading(now_reading);
                        account.setUsagepower(DataUtil.add(now_reading, -account.getBeforereading()));
                        account.setCost(DataUtil.add(cost, account.getCost()));
                        //修改账户当前读数和能源使用费用
                        accountService.updateAccount(account);

                    } else if (account.getPowertype() == 1||account.getPowertype() == 4) {//水
                        //根据账户表记编，取接口用电量数据
                        JSONObject jsonMain = GatewayUtil.get_latest(account.getCollectors(), "");
                        JSONObject data = (JSONObject) ((JSONObject) JSONObject.parse(jsonMain.get("data").toString())).get(account.getCollectors());
                        float val = Float.parseFloat(data.get("val").toString());
                        String format = String.format("%.2f", val);
                        float now_reading = Float.parseFloat(format);
                        String settleTime = data.get("_tm").toString();
                        float before_reading = account.getNowreading();
                        float usage = DataUtil.add(now_reading, -before_reading);
                        float cost = 0;
                        WaterUsage waterUsage = new WaterUsage();
                        if (price != null) {
                            waterUsage.setMerchantid(account.getMerchantid());
                            cost = DataUtil.mul(price.getWaterprice(), usage);
                            if (account.getPowertype() == 4){
                                int count = accountService.selectCount(account.getCollectors());
                                cost = DataUtil.divide(cost, count);
                                waterUsage.setShareusage(usage);
                                waterUsage.setSharecost(cost);
                            }else{
                                waterUsage.setAllusage(usage);
                                waterUsage.setCost(cost);
                                waterUsage.setNowreading(now_reading);
                            }
                        }
                        waterUsage.setSettletime(Integer.parseInt(settleTime));
                        waterUsageService.addTodayUsage(waterUsage);
                        Merchant merchant = merchantService.selectMerchantById(account.getMerchantid() + "");
                        merchant.setBalance(DataUtil.add(merchant.getBalance(), -cost));
                        merchantService.updateBalance(merchant);
                        account.setNowreading(now_reading);
                        account.setUsagepower(DataUtil.add(now_reading, -account.getBeforereading()));
                        account.setCost(DataUtil.add(cost, account.getCost()));
                        //修改账户当前读数和能源使用费用
                        accountService.updateAccount(account);
                    }
                }
                long nowTime = System.currentTimeMillis() / 1000;
                long todayTime = DataUtil.getTodayZeroPointTimestamps();
                if (nowTime - 1800 <= todayTime) {
                    List<ElecUsage> todayElecAllUsage = eleUsageService.getTodayAllUsage();
                    int time = Integer.parseInt(DataUtil.getNowYMD(todayTime - 10));
                    for (ElecUsage elecUsage : todayElecAllUsage) {
                        ElecUsage settleUsage = new ElecUsage();
                        settleUsage.setSettletime(time);
                        settleUsage.setMerchantid(elecUsage.getMerchantid());
                        int count = eleUsageService.getHistoryUsageByCode(settleUsage);
                        if (count == 0) {
                            elecUsage.setSettletime(settleUsage.getSettletime());
                            eleUsageService.addHistoryUsage(elecUsage);
                        }
                    }
                    eleUsageService.deleteAllTodayUsage();
                    List<WaterUsage> todayWaterAllUsage = waterUsageService.getTodayAllUsage();
                    for (WaterUsage waterUsage : todayWaterAllUsage) {
                        WaterUsage waterUsageAll = new WaterUsage();
                        waterUsageAll.setSettletime(time);
                        waterUsageAll.setMerchantid(waterUsage.getMerchantid());
                        int count = waterUsageService.getHistoryUsageByCode(waterUsageAll);
                        if (count == 0) {
                            waterUsage.setSettletime(waterUsageAll.getSettletime());
                            waterUsageService.addHistoryUsage(waterUsage);
                        }
                    }
                    waterUsageService.deleteAllTodayUsage();
                }

            }
        }catch (Exception e){

        }
    }

}

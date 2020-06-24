package com.dbb.dao;

import com.dbb.entity.WaterUsage;

import java.util.List;

public interface WaterUsageMapper {
    /**
     * 添加今日用水
     * @param waterUsage
     */
    void addTodayUsage(WaterUsage waterUsage);
    /**
     * 添加历史数据
     * @param waterUsage
     */
    void addHistoryUsage(WaterUsage waterUsage);
    /**
     * 清空今日数据
     * @param
     */
    void deleteAllTodayUsage();

    /**
     * 查询各商户今日数据结算总和
     * @return
     */
    List<WaterUsage> getTodayAllUsage();

    /**
     * 查询商户昨日结算数据条数
     * @return
     */
    int getHistoryUsageByCode( WaterUsage waterUsage);
}

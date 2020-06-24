package com.dbb.dao;

import com.dbb.entity.ElecUsage;

import java.util.List;

public interface ElecUsageMapper {
    /**
     * 添加今日数据
     * @param elecUsage
     */
   void addTodayUsage(ElecUsage elecUsage);
    /**
     * 添加历史数据
     * @param elecUsage
     */
    void addHistoryUsage(ElecUsage elecUsage);
    /**
     * 清空今日数据
     * @param
     */
    void deleteAllTodayUsage();

    /**
     * 查询各商户今日数据结算总和
     * @return
     */
    List<ElecUsage> getTodayAllUsage();

    /**
     * 查询商户昨日结算数据条数
     * @return
     */
    int getHistoryUsageByCode( ElecUsage elecUsage);
}

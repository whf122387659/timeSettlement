package com.dbb.service.impl;

import com.dbb.dao.WaterUsageMapper;
import com.dbb.entity.WaterUsage;
import com.dbb.service.WaterUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterUsageServiceImpl implements WaterUsageService {
    @Autowired
    private WaterUsageMapper waterUsageMapper;
    @Override
    public void addTodayUsage(WaterUsage waterUsage) {
        waterUsageMapper.addTodayUsage(waterUsage);
    }

    @Override
    public void addHistoryUsage(WaterUsage waterUsage) {
        waterUsageMapper.addHistoryUsage(waterUsage);
    }

    @Override
    public void deleteAllTodayUsage() {
        waterUsageMapper.deleteAllTodayUsage();
    }

    @Override
    public List<WaterUsage> getTodayAllUsage() {
        return waterUsageMapper.getTodayAllUsage();
    }

    @Override
    public int getHistoryUsageByCode(WaterUsage waterUsage) {
        return waterUsageMapper.getHistoryUsageByCode(waterUsage);
    }
}

package com.dbb.service.impl;

import com.dbb.dao.ElecUsageMapper;
import com.dbb.entity.ElecUsage;
import com.dbb.service.EleUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleUsageServiceImpl implements EleUsageService {
    @Autowired
    private ElecUsageMapper elecUsageMapper;
    @Override
    public void addTodayUsage(ElecUsage elecUsage) {
        elecUsageMapper.addTodayUsage(elecUsage);
    }

    @Override
    public void addHistoryUsage(ElecUsage elecUsage) {
        elecUsageMapper.addHistoryUsage(elecUsage);
    }

    @Override
    public void deleteAllTodayUsage() {
        elecUsageMapper.deleteAllTodayUsage();
    }

    @Override
    public List<ElecUsage> getTodayAllUsage() {
        return elecUsageMapper.getTodayAllUsage();
    }

    @Override
    public int getHistoryUsageByCode( ElecUsage elecUsage) {
        return elecUsageMapper.getHistoryUsageByCode(elecUsage);
    }
}

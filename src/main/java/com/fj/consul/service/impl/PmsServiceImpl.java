package com.fj.consul.service.impl;

import com.fj.consul.dao.PmsDao;
import com.fj.consul.entity.Pms;
import com.fj.consul.service.PmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmsServiceImpl implements PmsService {

    @Autowired
    PmsDao pmsDao;

    @Override
    public Pms find(int id) {
        return pmsDao.find(id);
    }

    @Override
    public void add(Pms pms) {
        pmsDao.insert(pms);
    }
}

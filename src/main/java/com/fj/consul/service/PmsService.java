package com.fj.consul.service;

import com.fj.consul.entity.Pms;

public interface PmsService {

    Pms find(int id);
    void add(Pms pms);
}

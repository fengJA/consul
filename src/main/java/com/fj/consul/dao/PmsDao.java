package com.fj.consul.dao;

import com.fj.consul.entity.Pms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsDao {
    public Pms find(int id);

    public void insert(Pms pms);
}

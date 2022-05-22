package com.example.datasource.journey.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface JourneyMapper {

    @Insert("insert into citys values(#{cid},#{pid},#{name})")
    public void MapToCity(int cid,int pid,String name);

    @Insert("insert into province values(#{pid},#{name} )")
    public void MapToProvince(int pid,String name);
}

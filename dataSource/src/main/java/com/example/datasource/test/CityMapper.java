package com.example.datasource.test;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper {

    @Insert("insert into cityMap values(#{cityName},#{cityNo})")
    public void InsertMap(String cityName,String cityNo);
}

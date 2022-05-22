package com.example.datasource.journey.service;

import com.example.datasource.journey.mapper.HigherMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HigherService {

    @Autowired
    HigherMapper higherMapper;


    public void InsertHighMsg(String updated_date,int high_count,int middle_count){
        higherMapper.InsertHighMsg(updated_date,high_count,middle_count);
        return ;
    }

    public void InsertHighList(String area_name,String province,String city,int county_code,String county,int type){
        higherMapper.InsertHighList(area_name, province, city, county_code, county, type);
        return ;
    }

    public void InsertMiddleList(String area_name,String province,String city,int county_code,String county,int type){
        higherMapper.InsertMiddleList(area_name, province, city, county_code, county, type);
        return ;
    }

    public void InsertCommunity(String area_name,String name){
        higherMapper.InsertCommunity(area_name, name);
    }
}

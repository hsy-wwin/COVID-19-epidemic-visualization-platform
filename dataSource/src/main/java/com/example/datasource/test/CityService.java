package com.example.datasource.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public void InsertMap(String cityName,String cityNo){
        cityMapper.InsertMap(cityName, cityNo);
    }
}

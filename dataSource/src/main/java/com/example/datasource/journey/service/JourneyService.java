package com.example.datasource.journey.service;

import com.example.datasource.journey.mapper.JourneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneyService {

    @Autowired
    private JourneyMapper journeyMapper;

    public void insertIntoCity(int cid,int pid,String name){
        journeyMapper.MapToCity(cid,pid,name);
        return ;
    }

    public void insertIntoProvince(int pid,String name){
        journeyMapper.MapToProvince(pid, name);
    }

}

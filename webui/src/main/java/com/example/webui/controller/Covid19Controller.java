package com.example.webui.controller;

import com.example.webui.bean.Result;
import com.example.webui.mapper.CovidMapper;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("covid")
public class Covid19Controller {

    @Autowired
    private CovidMapper covidMapper;
    // 全国疫情汇总信息
    @RequestMapping("getNationalData")
    public Result getNationalData(){
        Result result = new Result();
        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        Map<String, Object> nationalData = covidMapper.getNationalData(datetime).get(0);
        result.setData(nationalData);

        return result;
    }

    @RequestMapping("getNationalMapData")
    public Result getNationalMapData(){
        Result result = new Result();
        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        List<Map<String, Object>> nationalMapData = covidMapper.getNationalMapData(datetime);
        result.setData(nationalMapData);
        return result;
    }

    @RequestMapping("getCovidTimeData")
    public Result getCovidTimeData(){
        Result result = new Result();
        List<Map<String, Object>> covidTimeData = covidMapper.getCovidTimeData();
        result.setData(covidTimeData);

        return result;
    }

    @RequestMapping("getCovidImportData")
    public Result getCovidImportData(){
        Result result = new Result();
        String datetime = FastDateFormat.getInstance("yyyy-MM-dd").format(System.currentTimeMillis());
        List<Map<String, Object>> covidImportData = covidMapper.getCovidImportData(datetime);
        result.setData(covidImportData);

        return result;
    }

    @RequestMapping("getCovidWz")
    public Result getCovidWz(){
        Result result = new Result();
        List<Map<String, Object>> covidWz = covidMapper.getCovidWz();
        result.setData(covidWz);
        return result;
    }
}

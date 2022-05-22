package com.example.datasource.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

// 封装疫情数据的javaBean
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CovidBean {
    private String provinceName; // 省份名
    private String provinceShortName; // 省份的简写
    private String cityName;
    private Integer currentConfirmedCount; // 当前的确诊
    private Integer confirmedCount; // 累计确诊人数
    private Integer suspectedCount; // 疑似人数
    private Integer curedCount; // 治愈病例
    private Integer deadCount; // 死亡病例
    private Integer locationId; // 位置id
    private Integer pid;
    private String statisticsData; // 每天的数据
    private String cities;// 下属城市
    private String dateTime;//哪天的数据
}

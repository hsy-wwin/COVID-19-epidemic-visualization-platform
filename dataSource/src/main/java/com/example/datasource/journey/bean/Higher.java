package com.example.datasource.journey.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Higher {
    private String area_name;
    private String province;
    private String city;
    private int county_code;
    private String county;
    private List<String> communitys;
    private int type;
}

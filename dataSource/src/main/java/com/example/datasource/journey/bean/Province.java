package com.example.datasource.journey.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Province {
    private String province_id;
    private String province;
    private List<City> citys;
}

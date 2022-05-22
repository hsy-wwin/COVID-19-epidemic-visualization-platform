package com.example.datasource.journey.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class high_msg {
    private List<Higher> middle_list;
    private int middle_count;
    private List<Higher> high_list;
    private String updated_date;
    private int high_count;
}

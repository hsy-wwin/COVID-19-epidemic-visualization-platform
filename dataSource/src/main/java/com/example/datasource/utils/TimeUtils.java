package com.example.datasource.utils;

import org.apache.commons.lang3.time.FastDateFormat;

public class TimeUtils {

    public static String format(Long timestamp,String pattern){
        return FastDateFormat.getInstance(pattern).format(timestamp);
    }

    public static void main(String[] args) {
        String format = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd-hh-mm-ss");
        System.out.println(format);
    }
}

package com.example.datasource.journey.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HigherMapper {

    @Insert("insert into high_msg values(#{updated_date},#{high_count},#{middle_count})")
    public void InsertHighMsg(String updated_date,int high_count,int middle_count);

    @Insert("insert into high_list values(#{area_name},#{province},#{city},#{county_code},#{county},#{type})")
    public void InsertHighList(String area_name,String province,String city,int county_code,String county,int type);


    @Insert("insert into middle_list values(#{area_name},#{province},#{city},#{county_code},#{county},#{type})")
    public void InsertMiddleList(String area_name,String province,String city,int county_code,String county,int type);

    @Insert("insert into communitys values(#{area_name},#{name})")
    public void InsertCommunity(String area_name,String name);
}

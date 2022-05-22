package com.example.datasource.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.datasource.bean.CovidBean;
import com.example.datasource.config.KafkaProducerConfig;
import com.example.datasource.utils.HttpUtils;
import com.example.datasource.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Covid19DataCrawler {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //@Scheduled(cron = "0 0 8 * * ?") // 每天八点执行
    //@Scheduled(cron = "0/5 * * * * ?") // 每隔五秒执行一次
    // 爬取疫情数据
    public void test() {
        String html = HttpUtils.getHtml("http://ncov.dxy.cn/ncovh5/view/pneumonia");

        String dateTime = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");
        //System.out.println(html);

        //         getAreaStat
        Document doc = Jsoup.parse(html);
        Element getAreaStat = doc.getElementById("getAreaStat");
        String text = getAreaStat.toString();
        // 使用正则表达式
        String pattern = "\\[(.*)\\]";
        Pattern compile = Pattern.compile(pattern);

        Matcher matcher = compile.matcher(text);
        String jsonStr = "";
        if (matcher.find()) {
            jsonStr = matcher.group(0);
            // System.out.println(jsonStr);
        } else {
            System.out.println("no matcher");
        }
        // 准备解析json

        List<CovidBean> pcovidBeans = JSON.parseArray(jsonStr, CovidBean.class); // 省份bean
        for (CovidBean covidBean : pcovidBeans) {
            // 设置时间戳
            covidBean.setDateTime(dateTime);
            // 解析city
            String cityStr = covidBean.getCities();
            List<CovidBean> covidBeans = JSON.parseArray(cityStr, CovidBean.class);
            // 城市bean
            for (CovidBean bean : covidBeans) {
                bean.setDateTime(dateTime);
                bean.setPid(covidBean.getLocationId());
                bean.setProvinceShortName(covidBean.getProvinceShortName());
                bean.setProvinceName(covidBean.getProvinceName());
                // System.out.println(bean);
                String beanStr = JSON.toJSONString(bean);
                kafkaTemplate.send("covid19", bean.getPid(), beanStr);
            }
            // 获取历史疫情数据
            String statisticsDataUrl = covidBean.getStatisticsData();
            // 获取省份每天的统计数据
            String html1 = HttpUtils.getHtml(statisticsDataUrl);

            JSONObject jsonObject = JSON.parseObject(html1);
            String dataStr = jsonObject.getString("data");
            // 将url解析成数据内容 递归爬取
            covidBean.setStatisticsData(dataStr);
            covidBean.setCities(null);

            String pBeanStr = JSON.toJSONString(covidBean);

            kafkaTemplate.send("covid19", covidBean.getLocationId(), pBeanStr);
        }

    }
}

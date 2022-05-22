package com.example.datasource.Controller;

import com.example.datasource.crawler.Covid19DataCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    Covid19DataCrawler dataCrawler;

    @GetMapping
    public String testConn() {
        dataCrawler.test();

        return "successful";
    }
}

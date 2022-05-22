package com.example.datasource.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.datasource.journey.bean.high_msg;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class HttpUtils {

    private static PoolingHttpClientConnectionManager cm; // 声明httpclient连接池

    private static List<String> userAgentList = null; // 代理信息的配置

    private static RequestConfig requestConfig; // 请求参数的配置

    // 静态初始化 变量
    static {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .build();
        userAgentList = new ArrayList<String>();
        userAgentList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36 Edg/100.0.1185.44");
    }

    // 得到请求对象
    public static String getHtml(String url){
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent",userAgentList.get(userAgentList.size()-1));
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);

            System.out.println(response);

            if (response.getStatusLine().getStatusCode() == 200) {
                String html = EntityUtils.toString(response.getEntity(), "UTF-8");

                return html;
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                response.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String html = HttpUtils.getHtml("");
        System.out.println(html);
    }
}

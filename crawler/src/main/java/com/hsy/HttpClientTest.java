package com.hsy;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


public class HttpClientTest {
    @Test
    public void testGet() throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://www.itcast.cn/?username=xx");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36 Edg/100.0.1185.44");


        CloseableHttpResponse response = client.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200){
            System.out.println("响应成功");
            String s = EntityUtils.toString(response.getEntity(), "UTF-8");

            System.out.println(s);
        }

        response.close();
        client.close();
    }


    @Test
    public void testPool() throws Exception{
        PoolingHttpClientConnectionManager clientPool = new PoolingHttpClientConnectionManager();
        clientPool.setMaxTotal(200); // 设置池的最大连接数
        clientPool.setDefaultMaxPerRoute(20); // 每台主机的默认路由

        doGet(clientPool);

        doGet(clientPool);

    }

    private void doGet(PoolingHttpClientConnectionManager cm) throws Exception{
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet = new HttpGet("https://www.itcast.cn/?username=xx");

        CloseableHttpResponse response = client.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200) {
            String s = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(s);
        }
        response.close();
    }

    @Test
    public void testConfig() throws Exception{
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        // 配置请求信息


        // CloseableHttpClient client = HttpClients.createDefault();


        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config).build();

        HttpGet httpGet = new HttpGet("https://www.itcast.cn/?username=xx");

        CloseableHttpResponse response = client.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200){
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("拿到数据");

        }

        response.close();
        client.close();



    }
}

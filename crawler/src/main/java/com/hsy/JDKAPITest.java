package com.hsy;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class JDKAPITest {

    @Test
    public void testGet() throws Exception{
        //1.确定要访问的url
        URL url = new URL("https://www.itcast.cn/?username=xx");
        //2.获取连接对象
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //3.设置连接信息
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36 Edg/100.0.1185.44");
        connection.setConnectTimeout(30000);


        //4.获取数据
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String html = "";

        while((line = reader.readLine()) != null){
            html += line + '\n';
        }
        System.out.println(html);
        //5.关闭连接
        inputStream.close();
        reader.close();
    }

    @Test
    public void testPost() throws Exception{
        URL url = new URL("https://www.itcast.cn/");

        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);// 允许向url输出内容
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36 Edg/100.0.1185.44");
        connection.setConnectTimeout(30000);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write("username=xx".getBytes(StandardCharsets.UTF_8));

        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String html = "";

        while((line = reader.readLine()) != null){
            html += line + "\n";
        }
        System.out.println(html);

        inputStream.close();
        reader.close();


    }
}

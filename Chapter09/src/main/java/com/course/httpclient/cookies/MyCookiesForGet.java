package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore Store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url =bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件读取并拼接url
        String uri = bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        HttpGet get = new HttpGet(testUrl);
//        CloseableHttpClient HttpClient = HttpClients.createDefault();
//        BasicCookieStore cookieStore = new BasicCookieStore();
        this.Store = new BasicCookieStore();
        CloseableHttpClient HttpClient = HttpClients.custom().setDefaultCookieStore(Store).build();

        HttpResponse response = HttpClient.execute(get);
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        //获取cookies信息
        System.out.println("this is cookies:"+Store.getCookies());

//        List<Cookie> cookies = Store.getCookies();
//
//        for (Cookie cookie:cookies){
//            String name = cookie.getName();
//            String value = cookie.getValue();
//            System.out.println("cookie name="+name+";"+"cookie value="+value);
//        }

//        DefaultHttpClient client = new DefaultHttpClient();
//        HttpResponse response2 = client.execute(get);
//        result = EntityUtils.toString(response2.getEntity(),"gbk");
//        CookieStore store = client.getCookieStore();
//
//        List<Cookie> cookies2 = store.getCookies();
//
//        for (Cookie cookie:cookies2){
//            String name = cookie.getName();
//            String value = cookie.getValue();
//            System.out.println("cookie name="+name+";"+"cookie value="+value);
//        }

    }


    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl=this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        CloseableHttpClient HttpClient = HttpClients.custom().setDefaultCookieStore(Store).build();
        HttpResponse response = HttpClient.execute(get);
//        result = EntityUtils.toString(response.getEntity(),"gbk");
//        System.out.println(result);

        //获取状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if (statusCode == 200 ){
            result = EntityUtils.toString(response.getEntity(),"gbk");
            System.out.println(result);
        }

    }

}

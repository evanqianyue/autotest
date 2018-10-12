package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
        this.Store = new BasicCookieStore();
        CloseableHttpClient HttpClient = HttpClients.custom().setDefaultCookieStore(this.Store).build();
        HttpResponse response = HttpClient.execute(get);
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        //获取cookies信息
        List<Cookie> cookies = this.Store.getCookies();

        for (Cookie cookie:cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+name+";"+"cookie value="+value);
        }

    }


    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri =bundle.getString("test.post.with.cookies");
        String testUrl=this.url+uri;
        //声明一个Client对象，用来进行方法的执行

        //声明一个方法，这个方法是POST
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息，设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象进行响应结果的存储

        //设置cookies信息
        CloseableHttpClient Client = HttpClients.custom().setDefaultCookieStore(Store).build();
        //执行POST方法
        HttpResponse response =Client.execute(post);
        //获取响应结果
        String result;
        //result 的 type是string
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println("this is result:"+result);
        //处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转化成json对象
        JSONObject resultJson = new JSONObject(result);

        //获取到结果值
        // "json":{
        //        "name":"huhansan",
        //        "status":"ok"
        //        }
        String name = (String) resultJson.get("name");
        String status = (String) resultJson.get("status");

        //具体的判断返回结果的值
        Assert.assertEquals("huhansan",name);
        Assert.assertEquals("ok",status);
    }
}

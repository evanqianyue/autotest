package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;

import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        //旧写法
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//        TestConfig.HttpClient = HttpClients.createDefault();
        TestConfig.HttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();
    }

    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        //select * from loginCase where id = ?,s:sql的id，o:表示？
        LoginCase loginCase = session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println("TestConfig.loginUrl"+TestConfig.loginUrl);

        //发请求，获取结果
        String result = getResult(loginCase);

        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        //select * from loginCase where id = ?,o后面的数字代表？
        LoginCase loginCase = session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //发请求，获取结果
        String result = getResult(loginCase);

        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        System.out.println("loginCase.getUserName()"+loginCase.getUserName());
        System.out.println("loginCase.getPassword()"+loginCase.getPassword());

        //设置头信息
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //设置cookies
//        TestConfig.HttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();

        //存放返回结果
//        HttpResponse response = TestConfig.defaultHttpClient.execute(post);//旧写法
        HttpResponse response = TestConfig.HttpClient.execute(post);

        String result = EntityUtils.toString(response.getEntity(),"utf-8");

        //TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        System.out.println("TestConfig.store"+TestConfig.store);

        return result;
    }

}

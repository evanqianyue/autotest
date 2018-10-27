package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;

public class GetUserListTest {

    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserList() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase= session.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        //发送请求获取结果
        JSONArray resultJson = getResultJson(getUserListCase);

        //验证
        List<User> userList = session.selectList(getUserListCase.getExpected(),getUserListCase);

        for (User user:userList) {
            System.out.println("user:"+user.toString());
        }

        JSONArray userListJson = new JSONArray(userList);
        Assert.assertEquals(userListJson.length(),resultJson.length());

        for (int i = 0 ;i<resultJson.length();i++){
            JSONObject expect = (JSONObject) resultJson.get(i);
            JSONObject actual = (JSONObject) userListJson.get(i);
            Assert.assertEquals(expect.toString(),actual.toString());

        }
    }

    private JSONArray getResultJson(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        TestConfig.HttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();

        HttpResponse response = TestConfig.HttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result"+result);
        JSONArray jsonArray = new JSONArray(result);
        return  jsonArray;

    }
}

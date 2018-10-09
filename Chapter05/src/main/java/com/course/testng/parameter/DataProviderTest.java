package com.course.testng.parameter;

import org.testng.annotations.*;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void test1(String name, int age, String sex) {
        System.out.println("test1方法 name:" + name + ";" + "age:" + age + ";" + "sex:" + sex);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{
                {"zhangsan", 15, "male"},
                {"lishi", 20, "male"},
                {"wangwu", 30, "male"}
        };

        return o;
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test2方法 name:" + name + ";" + "age:" + age + ";");
    }

    @Test(dataProvider = "methodData")
    public void test3(String name, int age) {
        System.out.println("test3方法 name:" + name + ";" + "age:" + age + ";");
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"lishi", 22},
                    {"wangwu", 22}
            };
        } else if (method.getName().equals("test3")) {
            result = new Object[][]{
                    {"Q", 33},
                    {"M", 33}
            };
        }
        return result;
    }
}
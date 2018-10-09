package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite运行啦");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public static void AfterTest(){
        System.out.println("AfterTest");
    }

    @BeforeClass
    public static void BeforeClass(){
        System.out.println("BeforeClass");
    }

}

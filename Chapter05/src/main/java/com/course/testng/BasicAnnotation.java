package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("testcase1");
        System.out.printf("Baisc test1 Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test(enabled = true)
    public void testCase2(){
        System.out.println("testcase2");
        System.out.printf("Baisc test2 Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test(enabled = false)
    public void testCase3(){
        System.out.println("这个是不执行的case3");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("afterSuit");
    }

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("BeforeSuite");
    }
}

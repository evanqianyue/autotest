package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemos {

    @Test
    public void Test1(){
        Assert.assertEquals(1,2,"eee");
    }

    @Test
    public void Test2(){
        Assert.assertEquals(1,1,"eee");
    }

    @Test
    public void Test3(){
        Assert.assertEquals("aa","aa","eee");
    }

    @Test
    public void logDemo(){
        Reporter.log("this is log");
        throw new RuntimeException("自动抛出");
    }
}

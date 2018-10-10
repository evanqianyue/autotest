package com.course.testng.suite;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)//单位为毫秒
    public void testSuccess() throws InterruptedException {
        System.out.println("1");
        Thread.sleep(1000);
    }

    @Test(timeOut = 2000)//单位为毫秒
    public void testFailed() throws InterruptedException {
        System.out.println("2");
        Thread.sleep(3000);
    }

}

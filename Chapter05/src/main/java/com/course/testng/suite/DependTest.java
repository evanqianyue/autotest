package com.course.testng.suite;

import org.testng.annotations.Test;

public class DependTest {

    @Test
    public void testCase1(){
        System.out.println("testCase1");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"testCase1"})
    public void testCase2(){
        System.out.println("testCase2");
    }
}

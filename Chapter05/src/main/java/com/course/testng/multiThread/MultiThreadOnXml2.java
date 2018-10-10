package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml2 {

    @Test
    public void test1(){
        System.out.printf("XML2 test1 Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("XML2 test2 Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("XML2 test3 Thread Id : %s%n",Thread.currentThread().getId());
    }

}

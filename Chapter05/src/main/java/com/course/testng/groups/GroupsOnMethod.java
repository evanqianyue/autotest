package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void testCase1(){
        System.out.println("this is server case11");
    }

    @Test(groups = "server")
    public void testCase2(){
        System.out.println("this is server case22");
    }


    @Test(groups = "client")
    public void testCase3(){
        System.out.println("this is server case33");
    }


    @Test(groups = "client")
    public void testCase4(){
        System.out.println("this is server case44");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前的方法");
    }


    @AfterGroups("server")
    public void AfterGroupsOnServer(){
        System.out.println("这是服务端组运行之后的方法");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是Client组运行之前的方法");
    }


    @AfterGroups("client")
    public void AfterGroupsOnClient(){
        System.out.println("这是Client组运行之后的方法");
    }

}

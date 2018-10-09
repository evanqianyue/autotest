package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    @Test(enabled = false)
    public void teacher1(){
        System.out.println("GroupsOnClass3.teacher1");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3.teacher2");
    }
}
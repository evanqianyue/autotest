package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    public static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri ="";
        //最终的测试地址
        String testUrl;


        //login
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }


        //updateUserInfo
        if (name == InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }


        //getUserList
        if (name == InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");
        }

        //getUserInfo
        if (name == InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }


        //addUser
        if (name == InterfaceName.ADDUSER){
            uri = bundle.getString("addUser.uri");
        }

        testUrl = address+uri;
        return testUrl;
    }

}

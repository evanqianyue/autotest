package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@Api(value = "/", description = "这是全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个get方法可以获取Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息
        //HttpServerletResponse 装响应信息
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "骚年，恭喜你获得Cookies信息成功!!!";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带cookies信息才能访问的get请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "Cookies不能为空";
        }      
        else{
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                    return "这是一个携带Cookie才能访问的get请求";
                }
            }
        }
        return "你必须携带正确的Cookies信息";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式url：key=values&key=value
     * 我们来模拟获取商品的列表
     */

    @RequestMapping(value = "/get/with/param" ,method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求（第一种实现）",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        myList.put("干脆面", 2);
        myList.put("衬衫", 30);
        return myList;
    }

    /**
     * 开发第二种需要携带参数才能访问的get请求
     * 第二种实现方式url：ip:port/get/with/param/10/20
     * 我们来模拟获取商品的列表
     */

    @RequestMapping(value = "get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get请求（第二种实现）",httpMethod = "GET")
    public Map<String,Integer> myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子", 400);
        myList.put("干脆面", 22);
        myList.put("衬衫", 35);
        return myList;

    }
}


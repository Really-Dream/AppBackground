package com.dream.jie.huang.appbackground.controller;

import com.dream.jie.huang.appbackground.entity.Title;
import com.dream.jie.huang.appbackground.mapper.AppBackgroundMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * APP后台
 */
@RestController
public class AppBackground {

    @Autowired
    AppBackgroundMapper appBackgroundMapper;

    private Gson gson = new Gson();

    /**
     *  答题总次数
     * @param userid 用户ID
     * @return
     */
    @RequestMapping(value = "/count")
    public String getCount(String userid){
        return gson.toJson(String.valueOf(appBackgroundMapper.getCount(userid)));
    }

    /**
     * 新建用户
     * @param username 用户名
     * @param userid    用户ID
     * @param pwd   密码
     * @param org   组织
     * @return
     */
    @RequestMapping(value = "/create")
    public String CreateUserServlet(String username,String userid,String pwd,String org){
        int i= appBackgroundMapper.beforeCreate(userid);
        if(i > 0){
            return gson.toJson("repeat");
        }else {
            i = appBackgroundMapper.insertUser(userid,username,pwd,org);
            if(i > 0){
                return gson.toJson("true");
            }else{
                return gson.toJson("false");
            }
        }
    }

    /**
     * 登录
     * @param userid 用户ID
     * @param pwd   密码
     * @return
     */
    @RequestMapping(value = "login")
    public String Login(String userid,String pwd){
        int i = appBackgroundMapper.login(userid,pwd);
        if(i > 0){
            return gson.toJson("true");
        }else{
            return gson.toJson("false");
        }
    }

    /**
     * 获取组织
     * @return
     */
    @RequestMapping(value = "org")
    public String getOrg(){
        List<String> list = appBackgroundMapper.getOrg();
        return gson.toJson(list);
    }

    /**
     * 获取题目
     * @return
     */
    @RequestMapping(value = "/getTitle")
    public String getTitle(){
        List<Title> list = appBackgroundMapper.getTitle();
        return gson.toJson(list);
    }

    /**
     * 提交答题结果
     * @param userid
     * @param grade
     * @return
     */
    @RequestMapping(value = "result")
    public String insertResult(String userid,String grade){
        int i = appBackgroundMapper.insertResult(userid,grade);
        if(i > 0){
            return gson.toJson("true");
        }else{
            return gson.toJson("false");
        }
    }

    /**
     * 下载地址
     * @return
     */
    @RequestMapping(value = "downloadAddress")
    public String downloadAddress(){
        String downloadAddress = appBackgroundMapper.downloadAddress();
        return gson.toJson(downloadAddress);
    }

}

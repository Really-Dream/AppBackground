package com.dream.jie.huang.appbackground.controller;

import com.dream.jie.huang.appbackground.entity.Page;
import com.dream.jie.huang.appbackground.entity.Result;
import com.dream.jie.huang.appbackground.mapper.ResultMapper;
import com.dream.jie.huang.appbackground.service.ResultQueryService;
import com.dream.jie.huang.appbackground.tools.ResultHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 成绩查询页面
 */
@Controller
public class ResultQueryController {

    @Resource
    ResultMapper resultMapper;

    @Autowired
    ResultQueryService resultQueryService;

    @Resource
    ResultHandle resultHandle;

    @RequestMapping(value = "select")
    public String queryResult(){
        return "Result";
    }

    @RequestMapping(value = "getPage")
    @ResponseBody
    public Page getPage(HttpServletResponse response,Page page, String userid, String startTime, String endTime){
        response.addHeader("Access-Control-Allow-Origin","https://www.whoisyours.cn");
        int count = resultMapper.getCountForResult(userid,startTime,endTime);
        page.setTotalRow(count);
        page.setTotalPage(page.getTotalPages());
        page.initPage(page);
        List<Result> list = resultMapper.getResult(page,userid,startTime,endTime);
        page.setList(resultHandle.doResult(list));
        return page;
    }

    @RequestMapping(value = "download")
    public void download(HttpServletResponse response,String userid,String startTime,String endTime){
        List<Result> list = resultMapper.getDownload(userid,startTime,endTime);
        try {
            resultQueryService.setDownload(response,resultHandle.doResult(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.dream.jie.huang.appbackground.service;

import com.dream.jie.huang.appbackground.entity.Result;
import com.dream.jie.huang.appbackground.tools.SimpleExcelWrite;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Dream on 2017/7/24.
 */
@Service
public class ResultQueryService {

    public void setDownload(HttpServletResponse response, List<Result> list) throws IOException {
        String fname = "成绩";
        OutputStream os = response.getOutputStream();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        fname = java.net.URLEncoder.encode(fname,"UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"UTF-8")+".xls");
        response.setContentType("application/msexcel");

        SimpleExcelWrite simpleExcelWrite = new SimpleExcelWrite();
        simpleExcelWrite.createExcel(os,list);
    }


}

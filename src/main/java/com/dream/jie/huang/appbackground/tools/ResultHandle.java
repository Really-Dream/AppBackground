package com.dream.jie.huang.appbackground.tools;

import com.dream.jie.huang.appbackground.entity.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dream on 2017/7/24.
 */
@Service
public class ResultHandle {

    public List<Result> doResult(List<Result> list){
        for (Result result : list){
            result.setGrade(String.valueOf(doGrade(Integer.valueOf(result.getGrade()))));
        }
        return list;
    }


    public int doGrade(int grade){
        if(grade%5==0 && grade%10 !=0){
            grade = grade + 5;
        }
        if(grade>100){
            grade = grade/2;
            return doGrade(grade);
        }
        return grade;
    }
}

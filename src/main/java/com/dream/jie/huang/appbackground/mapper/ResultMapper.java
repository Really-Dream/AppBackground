package com.dream.jie.huang.appbackground.mapper;

import com.dream.jie.huang.appbackground.entity.Page;
import com.dream.jie.huang.appbackground.entity.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Dream on 2017/7/24.
 */
@Mapper
public interface ResultMapper {

    List<Result> getResult(@Param("page")Page<Result> page, @Param("userid")String userid,
                           @Param("startTime")String startTime, @Param("endTime")String endTime);

    int getCountForResult(@Param("userid")String userid,@Param("startTime")String startTime, @Param("endTime")String endTime);

    List<Result> getDownload(@Param("userid")String userid,@Param("startTime")String startTime, @Param("endTime")String endTime);
}

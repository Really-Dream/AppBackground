package com.dream.jie.huang.appbackground.mapper;

import com.dream.jie.huang.appbackground.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * SQL
 */
@Mapper
public interface AppBackgroundMapper {

//    @Select("select count(*)+1 count from tb_result where username = #{userid} ")
    int getCount(@Param("userid") String id);

//    @Insert("insert into tb_user values(#{userid},#{pwd},#{username},#{org},sysdate())")
    int insertUser(@Param("userid")String userid,@Param("username")String username,@Param("pwd")String pwd,@Param("org")String org);

//    @Select("select count(*) from tb_user where userid=#{userid} and pwd=#{pwd}")
    int login(@Param("userid")String userid,@Param("pwd")String pwd);

//    @Select("select count(*) from tb_user where userid=#{userid}")
    int beforeCreate(@Param("userid")String userid);

//    @Select("select * from tb_org")
    List<String> getOrg();

//    @Select("SELECT * FROM question  LIMIT 13 ")
    List<Title> getTitle();

//    @Insert("insert into tb_result values(#{userid},#{grade},sysdate())")
    int insertResult(@Param("userid")String userid,@Param("grade")String grade);

//    @Select("select * from tb_downloadAddress")
    String downloadAddress();
}

package com.example.aliyun_oss.web.dao;


import com.example.aliyun_oss.web.pojo.CurrentUserInfo;
import com.example.aliyun_oss.web.pojo.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by li on 2019/3/16.
 */
//@Repository
//@Mapper
public interface UserDao {

    User saveUser(User user);

    List<User> queryUserList(@Param("username") String username);

    int queryUserTotal(@Param("username") String username);
//    @SelectProvider(type = UserProvider.class,method ="queryUserByName")
//    @Select("select *from user where username=#{username}")
    User queryUserByName(@Param("username") String username);

    CurrentUserInfo queryUserInfoByName(@Param("username") String username);
}


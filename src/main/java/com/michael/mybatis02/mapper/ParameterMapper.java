package com.michael.mybatis02.mapper;

import com.michael.mybatis02.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ParameterMapper {
    List<User> getAllUser();


    User getUserByUserId(int id);

    /**
     *
     *
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 使用@Param进行传参
     *
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);


    /***
     * 使用Map进行传参
     *
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);


    int insertUser(User user);


}

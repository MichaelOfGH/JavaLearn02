package com.michael.mybatis02.mapper;

import com.michael.mybatis02.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ParameterMapper {

    /**
     * 获取全部用户
     *
     * @return
     */
    List<User> getAllUser();


    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    User getUserByUserId(int id);

    /**
     * 检查登录
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


    /**
     * 使用Map进行传参
     *
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加新用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);


}

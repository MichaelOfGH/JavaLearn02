package com.michael.mybatis02.mapper;

import java.util.List;

import com.michael.mybatis02.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Michael
 * @Date 2023/3/22 17:17
 * @ApiNote
 */

public interface SelectMapper {

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    //User getByUserId(@Param("id") int id);

    /**
     * 根据username获取用户
     *
     * @param username
     * @return
     */
    List<User> getByUserName(@Param("username") String username);

}

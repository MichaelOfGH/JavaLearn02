package com.michael.mybatis02.mapper;

import java.util.List;

import com.michael.mybatis02.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Michael
 * @Date 2023/3/29 16:43
 * @ApiNote
 */

public interface SelectTableMapper {

    List<User> getUserByTableName(@Param("tableName") String tabName);

}


package com.michael.mybatis02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author Michael
 * @Date 2023/3/29 16:20
 * @ApiNote
 */
public interface UpdateMapper {

    int DeleteById(@Param("ids") String ids);

}

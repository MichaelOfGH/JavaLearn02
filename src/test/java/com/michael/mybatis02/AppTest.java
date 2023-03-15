package com.michael.mybatis02;

import com.michael.mybatis02.mapper.ParameterMapper;
import com.michael.mybatis02.model.User;
import com.michael.mybatis02.utils.SqlSessionUtils;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    @Test
    public void AppTest(String testName) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();

        allUser.forEach(user -> System.out.println(user));

    }


}

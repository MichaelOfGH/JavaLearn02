package com.michael.mybatis02.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {


    public static SqlSession getSqlSession() {
        SqlSession session = null;
        try {
            InputStream resourceStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = builder.build(resourceStream);
            session = sessionFactory.openSession(true);
            return session;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }


}

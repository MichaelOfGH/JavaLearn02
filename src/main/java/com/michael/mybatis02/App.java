package com.michael.mybatis02;

import com.michael.mybatis02.mapper.ParameterMapper;
import com.michael.mybatis02.mapper.SelectMapper;
import com.michael.mybatis02.mapper.SelectTableMapper;
import com.michael.mybatis02.mapper.UpdateMapper;
import com.michael.mybatis02.model.User;
import com.michael.mybatis02.utils.SqlSessionUtils;
import lombok.var;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        var mapper = sqlSession.getMapper(ParameterMapper.class);
        var selectmapper = sqlSession.getMapper(SelectMapper.class);
        var updatemapper = sqlSession.getMapper(UpdateMapper.class);

        /*
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));

        User user = mapper.getUserByUserId(2);
        System.out.println(user);
        User user = mapper.checkLogin("Michael", "Michael");
        System.out.println(user);


        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("username", "Michael");
        queryMap.put("password", "Michael");
        User user = mapper.checkLoginByMap(queryMap);
        System.out.println(user);

        User user = new User(0, "Mike", "password", "18", 'F', "michaelofgle@gmail.com");
        int insertUser = mapper.insertUser(user);
        System.out.println(insertUser);

        User user = mapper.checkLoginByParam("Mike", "password");
        System.out.println(user);
*/
        /*
         *
         * MyBatis获取参数值的两种方式：
         *   ${} 本质为字符串拼接
         *   #{} 本质为占位符赋值
         * 故#{}优先，能避免SQL注入、无需在SQL中加入单引号等，除非需要使用关键字
         *
         * MyBatis获取参数值的各种情况
         * 1.mapper接口方法的参数为单个字面量类型
         *      可通过#{}或者${}获取参数值，但${}中需要注意单引号问题
         * 2.mapper接口方法参数为多个时
         *      MyBatis会将参数放到一个map集合中，以两种方式进行存放
         *      a.以arg0、arg1...为键，参数为值
         *      b.以param1、param2...为键，参数为值
         *      因此只需要通过#{}或者${}以键的方式进行访问即可
         * 3.若mapper接口参数有多个时，可以手动将参数放在一个map中进行存放
         *      只需通过#{}或${}以键的方式进行访问即可
         * 4.如果mapper接口的参数是实体类
         *      和3类似，可直接访问属性名进行获取参数值
         * 5.通过使用@Param命名参数
         *      MyBatis会将参数放到一个map集合中，以两种方式进行存放(args0不存在，param1、param2存在)
         *
         * */



        /*
        模糊查询：
        一般使用 like "%"#{变量名}"%" 这种方式进行查询

        var users = selectmapper.getByUserName("Mich");
        users.forEach(user -> {
            System.out.println(user.toString());
        });
        */


        /*
        批量删除：
        一般使用集合进行删除
        如果不使用集合，用字符串的话，需要用foreach
        var dels = new ArrayList<Integer>();
        dels.add(1);
        dels.add(2);
        dels.add(3);
        //updatemapper.DeleteById(dels);
        updatemapper.DeleteById("1,2,3");
         */


        /*使用动态表名查询
          需要使用${}，否则#{}会自动创建单引号，使表名不起作用
         */
        var selectTableMapper = sqlSession.getMapper(SelectTableMapper.class);
        var user = selectTableMapper.getUserByTableName("t_user");
        System.out.println(user);

        /*
        useGenerateKeys:设置当前标签中的SQL使用了自增的Id
        keyProperty:将自增的主键的值复制给传输到映射属性

         */




        /*
        解决列名和属性名不一致的情况：
        1.为字段起别名(MyBatis中typeAliases节点)
        2.使用全局配置mapUnderscoreToCamelCase，将_列名自动映射为驼峰命名的字段名
        3.使用ResultMap设置映射关系，映射时尽量将所有列都设置(更新时不需要操作)
        */

    }

}

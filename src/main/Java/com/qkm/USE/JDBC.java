package com.qkm.USE;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    public static void main(String[] args) throws Exception {
        /*驱动管理对象DriverManager
        1 注册驱动
        //让jdbc知道是哪个数据库链接的，启动注册驱动mysql jar包
        Class.forName("com.mysql.jdbc.driver");
        2 连接数据库
        //第一个为mysql数据库的连接标准，如果是本机下的mysql则可以不写,然后是用户名和密码
        //完整的    jdbc://IP地址：mysql端口号（默认3306）//库

        Connection root = DriverManager.getConnection("jdbc:///Text", "root", "13468724917qkm,");
        */
        /*Connection 数据库连接对象
          1 获取执行sql语句的 对象Statement   creatStatement()
          2管理事物
         */
        /*
        Statement 执行sql语句的对象(一般用于执行DML 语句，DQL语句 DDL 语句用的很少)
        int executeUpdate()//返回值为受到影响的行数
         */

    }

}

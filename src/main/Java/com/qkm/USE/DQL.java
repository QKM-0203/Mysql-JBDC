package com.qkm.USE;

import java.sql.*;

public class DQL {
    public static void main(String[] args) {
        Connection root1 = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册驱动-
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            root1 = DriverManager.getConnection("jdbc:mysql:///Text", "root", "13468724917qkm,");
            //获取执行sql语句的对象
            statement = root1.createStatement();
            String sqlDQL = "select * from Student";
            //查询语句封装为对象
            resultSet = statement.executeQuery(sqlDQL);

            //光标向下先移动一行，因为最开始指的是名字的那一行
            resultSet.next();

            //一次获取某一行的某一列的数据，getInt(参数是int值则为列的编号（从1开始），或者参数是String就是列的名称)返回Int
            int anInt = resultSet.getInt(1);
            String Name = resultSet.getString("Name");
            System.out.println(anInt+""+Name+"");//1qkm

            /*
            循环判断取出所有的数据
            while(resultSet.next()){
                //一次获取某一行的某一列的数据，getInt(参数是int值则为列的编号（从1开始），或者参数是String就是列的名称)返回Int
                int anInt1 = resultSet.getInt(1);
                String Name1 = resultSet.getString("Name");
                System.out.println(anInt1+""+Name1+"");//1qkm
            }
            */

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(root1 != null){
                //防止前面的语句没有执行成功，那莫root就是null
                try {
                    root1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //同上
                if(statement != null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                //同上
                if(resultSet != null){
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}

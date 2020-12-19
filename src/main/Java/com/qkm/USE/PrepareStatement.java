package com.qkm.USE;

import java.sql.*;
import java.util.Scanner;

//防止sql语句产生安全性的问题
public class PrepareStatement {
    Connection root = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    private  boolean isLogin(int id,String name){
        if(id < 0 || name == null){
            return false;
        }
        //使用工具类开启连接
        try {
            root = JDBCUtils.getConnection();
            String sql = "select * from Student where ID = ? and NAME = ?";
            //获取执行sql的对象
            preparedStatement = root.prepareStatement(sql);
            //通过对象设置？的值前面的数字代表是第几个问号
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            //执行sql是子类特有的方法，不用传参。
            resultSet = preparedStatement.executeQuery();
            //直接查询是否有行数就行
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //使用工具类关闭资源
            JDBCUtils.close(preparedStatement, root,resultSet);
        }
        return false;

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PrepareStatement prepareStatement = new PrepareStatement();
        if(prepareStatement.isLogin(scanner.nextInt(),scanner.next())){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
    }
}

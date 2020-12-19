package com.qkm.USE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Business {
    Connection root = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement1 = null;
    private  void update(int id,String name){
        //使用工具类开启连接
        try {
            root = JDBCUtils.getConnection();
            //开启事务
            root.setAutoCommit(false);
            String sql = "update Student set ID = ? where NAME = ? ";
            String sql1 = "update Student set ID = ? where NAME = ?";
            //获取执行sql的对象
            preparedStatement = root.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            /*
            这样会产生一部分数据改了，一部分数据没改的情况，利用事务可以解决
            preparedStatement.executeUpdate();
            //手动加异常
            int q = 3/0;
             */
            int q = 3/0;


            preparedStatement1 = root.prepareStatement(sql1);
            preparedStatement1.setInt(1,id);
            preparedStatement1.setString(2,name);


             preparedStatement1.executeUpdate();
            //没有抛出异常就直接提交，若抛出异常就回滚（在catch里面）
             root.commit();
             //此时的异常应该抓得大一点，神魔都抓
        } catch (Exception e) {
            try {
                if(root != null){
                    root.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //使用工具类关闭资源
            JDBCUtils.close(preparedStatement, root,resultSet);
        }


    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Business business = new Business();
         business.update(scanner.nextInt(),scanner.next());
    }
}

package com.qkm.Text;

import com.qkm.USE.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
      Connection root = null;
      Statement statement = null;
      ResultSet resultSet = null;

    private  boolean isLogin(int id,String name){
        if(id < 0 || name == null){
            return false;
        }
        //使用工具类开启连接
        try {
            root = JDBCUtils.getConnection();

            statement = root.createStatement();

            String sql = "select * from Student where ID = '"+"id'"+" and NAME= '"+name+"'";
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //使用工具类关闭资源
            JDBCUtils.close(statement, root,resultSet);
        }
      return false;

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        if(login.isLogin(scanner.nextInt(),scanner.next())){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
    }
}

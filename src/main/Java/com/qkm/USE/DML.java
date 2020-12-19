package com.qkm.USE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DML {
    public static void main(String[] args) {
        Connection root = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
             root = DriverManager.getConnection("jdbc:mysql:///Text", "root", "13468724917qkm,");
             //获取执行sql语句的对象
             statement = root.createStatement();
             //写要执行的sql(插入语句)语句
             //String sqlInsert = " INSERT INTO table_Money values(178,'qkm',237,'qwe',238)";
             //执行sql（更新）语句
            //String sqlUpdate = "update table_Money set Text_id = 90 where Text_name = 'qkm' ";
            //执行sql（删除）语句
            String sqlDelete = "delete from Class where C_ID = 6";
          //  int i1 = statement.executeUpdate(sqlUpdate);
           // int i = statement.executeUpdate(sqlInsert);
            int i2 = statement.executeUpdate(sqlDelete);
            //System.out.println(i);//1
            //System.out.println(i1);
            System.out.println(i2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(root != null){
                //防止前面的语句没有执行成功，那莫root就是null
                try {
                    root.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //同上
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*
select Name from com.qkm.Text.Student s
inner JOIN Class c on c.C_great > 85 AND c.C_ID = s.ID;

select NAME from com.qkm.Text.Student
UNION
select AVG(C_great) avg  from Class s
Having   C_great > avg;
 */

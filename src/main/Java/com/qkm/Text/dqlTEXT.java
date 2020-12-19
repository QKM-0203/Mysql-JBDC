package com.qkm.Text;

import com.qkm.USE.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dqlTEXT {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<?> objects = new dqlTEXT().fIndAll();
        System.out.println(objects.toString());
    }
    Connection root = null;
    Statement statement = null;
    ResultSet resultSet = null;
    private List<Student> fIndAll() throws ClassNotFoundException, SQLException {
        List<Student> students = new ArrayList<>();
        //使用工具类开启连接
        root = JDBCUtils.getConnection();
        statement = root.createStatement();
        String sql = "select * from Student";
        resultSet = statement.executeQuery(sql);
        //让引用只有一个不断使用，可以防止栈溢出
        Student stu  = null;
        while(resultSet.next()){
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            stu = new Student();
            stu.setID(id);
            stu.setName(name);
            students.add(stu);
        }
        //使用工具类关闭资源
        JDBCUtils.close(statement, root,resultSet);
        return students;
    }
}

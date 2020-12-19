package com.qkm.USE;
import com.qkm.Text.Student;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * JDBCTemplate是利用Spring封装的一个类，很方便，一些资源的
 * 关闭和执行sql的对象就不用来获取了，该类直接封装成方法了，很方便
 *
 */
//使用JDBC
public class jdbcTemplate {
    //使用druidJDBCUtil来获取JdbcTemplate对象
    private static  JdbcTemplate  template= new JdbcTemplate(druidJDBCUtils.getDataSource());

    /**
     * JUNIT测试，加上注释可以让方法独立执行
     */
    @Test
    public void test1(){
      System.out.println("1");
    }

    //查询方法返回一个存储所有的(封装成为)对象list,将表的一行存为一个对象，就像是list里面放了Map
    public static List<Student> QueryReturnList(){
        String sql = "select * from Student";
        //后面的Bean..以javaBean的形式存起来，参数是某个类的字节玛对象。
        List<Student> qkm = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return  qkm;
    }
    //查询方法将一个对象的属性利用键值对存在Map里面，只能存一个对象
    public static Map<String,Object> QueryReturnMap(){
        String sql = "select * from Student where ID = ?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql,2);
        //System.out.println(stringObjectMap);{ID=2, NAME=sc}
        return stringObjectMap;
    }


    //更新
    public static void update(){
        String sql = "update Student set ID = ? where NAME = ?";
        template.update(sql,10,"123");
        String sql1 = "delete Student from Student where ID = ?";
        template.update(sql1,10);
       String sql2 = "insert into Student values(?,?)";
       template.update(sql ,45,"er");
    }

    public static void main(String[] args) {
        List<Student> students = jdbcTemplate.QueryReturnList();
        for (Student student : students) {
            System.out.println(student);//其中的一个，com.qkm.Text.Student{ID=2, Name='sc'}
        }
        Map<String, Object> stringObjectMap = jdbcTemplate.QueryReturnMap();
        System.out.println(stringObjectMap);//{ID=2, NAME=sc}

        //update();
    }

}

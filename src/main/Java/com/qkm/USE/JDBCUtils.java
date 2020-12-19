package com.qkm.USE;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

//JDBC的一个工具类，将连接数据库，关闭资源封装成一个方法，以后可以直接调用
  public class JDBCUtils {
       
    //数据库连接的库的url
    private static String url;
    //使用者
    private static String user;
    //密码
    private static String password;
    //驱动的
    private static String driver;

    /**
     *静态代码快为了让上面的变量只赋值一次，同时读取资源文件也只读一次，静态代码快只是加载一次
     */
    static{
        Properties properties = new Properties();
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        URL resource = classLoader.getResource("jdbc.properties");
        //System.out.println(resource);
        //将此抽象路径名转换为一个路径名字符串。所得到的字符串使用默认名称分隔符来分隔名称序列中的名称。
        String path = resource.getPath();
        //System.out.println(path);
        try {
            properties.load(new FileReader(path));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象，
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, user, password);
    }


    /**
     * 关闭资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement,Connection connection){
        if(statement != null){
           try {
              statement.  close();
               } catch (SQLException e) {
            e.printStackTrace();
             }
       }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上面的重载形式
     * @param statement
     * @param connection
     * @param resultSet
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       close(statement,connection);
    }
}

package com.nl.common;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils {
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@10.1.0.211:1521:kf";
    private static String user = "ccs_nd";
    private static String pwd = "ccs_nd";
    private static Integer initSize = 5;
    private static Integer maxSize = 20;
    //连接池对象
    private static BasicDataSource ds;
    //加载参数
    static{
        //创建连接池
        ds = new BasicDataSource();
        //设置参数
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(pwd);
        ds.setInitialSize(initSize);
        ds.setMaxActive(maxSize);
    }
    /*
     * 以上就是将配置文件里的参数全部读取出来，接下来就是要
     * 写两个方法，一个是用来创建连接的，一个关闭连接
     * */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}

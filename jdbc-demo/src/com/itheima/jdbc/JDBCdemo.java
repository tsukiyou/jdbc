package com.itheima.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCdemo {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver"); //注册驱动
        // 获取连接：如果连接的是本机mysql且端口为3306，可省略
        String url="jdbc:mysql:///db1";
        String username="root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // sql语句
        String sql = "update account set money = 2000 where id=1";

        Statement stat=conn.createStatement();
        int count = stat.executeUpdate(sql);
        System.out.println(count);
        stat.close();
        conn.close();
    }
}

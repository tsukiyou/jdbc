package com.itheima.jdbc;

import pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCdemoUserLogin {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver"); //注册驱动
        // 获取连接：如果连接的是本机mysql且端口为3306，可省略
        String url="jdbc:mysql:///db1";
        String username="root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="张三";
        String pwd="123456";
        // 定义sql
        String sql = "select * from account where name='"+name+"' and  password='"+pwd+"'";

        // 获取statement对象
        Statement stmt=conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登陆成功");
        }else System.out.println("登陆失败");
        rs.close();
        stmt.close();
        conn.close();
    }
}

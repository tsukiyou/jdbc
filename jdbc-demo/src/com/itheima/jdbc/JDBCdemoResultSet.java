package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCdemoResultSet {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver"); //注册驱动
        // 获取连接：如果连接的是本机mysql且端口为3306，可省略
        String url="jdbc:mysql:///db1";
        String username="root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义sql
        String sql = "select * from account";

        // 获取statement对象
        Statement stmt=conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 处理结果，遍历rs的所有数据
        while (rs.next()) {
            int id=rs.getInt(1);
            String name = rs.getString(2);
            double money= rs.getDouble(3);
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("----------");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}

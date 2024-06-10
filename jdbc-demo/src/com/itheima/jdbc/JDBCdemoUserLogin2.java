package com.itheima.jdbc;

import java.sql.*;

public class JDBCdemoUserLogin2 {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver"); //注册驱动
        // 获取连接：如果连接的是本机mysql且端口为3306，可省略
        String url="jdbc:mysql:///db1";
        String username="root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="张三";
        String pwd="1236";
        // 定义sql
        String sql = "select * from account where name=? and  password = ?";

        // 获取pstmt对象
        PreparedStatement pstmt=conn.prepareStatement(sql);

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        // 执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断登录是否成功
        if (rs.next()) {
            System.out.println("登陆成功");
        }else System.out.println("登陆失败");
        rs.close();
        pstmt.close();
        conn.close();
    }
}

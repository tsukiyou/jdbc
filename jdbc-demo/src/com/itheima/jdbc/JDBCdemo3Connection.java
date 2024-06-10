package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo3Connection {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql:///db1";
        String username="root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql1 = "update account set money = 2000 where id=1";
        String sql2 = "update account set money = 3000 where id=2";
        Statement stat=conn.createStatement();

        try {
            //开启事务
//            conn.setAutoCommit(false);
            int count = stat.executeUpdate(sql1);
            System.out.println(count);
            int i=3/0;
            int count2 = stat.executeUpdate(sql2);
            System.out.println(count2);
            //提交事务
//            conn.commit();
        } catch (Exception e) {
//            conn.rollback();
            throw new RuntimeException(e);
        }

        stat.close();
        conn.close();
    }
}

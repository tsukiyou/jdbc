package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class BrandTestdelete {
    public static void main(String[] args) throws Exception{

        int id = 4;

        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "delete from tb_brand where id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);

        int count = pstmt.executeUpdate();

        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }
}

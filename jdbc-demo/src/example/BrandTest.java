package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    public static void main(String[] args) throws Exception{
        Properties prop=new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs=pstmt.executeQuery();

        List<Brand> brands=new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            Brand brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setDescription(description);
            brand.setOrdered(ordered);
            brand.setStatus(status);

            brands.add(brand);
        }
        System.out.println(brands);

        rs.close();
        pstmt.close();
        conn.close();
    }
}

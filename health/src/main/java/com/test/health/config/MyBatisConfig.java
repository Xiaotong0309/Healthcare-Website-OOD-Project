package com.test.health.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
@MapperScan("com.test.health.dao.mapper")
public class MyBatisConfig {


    @Value("${spring.datasource.druid.password}")
    String password;
    @Value("${spring.datasource.druid.driver-class-name}")
    String driver;
    @Value("${spring.datasource.druid.url}")
    String url;
    @Value("${spring.datasource.druid.username}")
    String username;

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

//        Properties properties = new Properties();
//        String[] configs = config.split(";");
//        for (String cfg : configs) {
//            int index = cfg.indexOf("=");
//            String key = cfg.substring(0, index);
//            String value = cfg.substring(index + 1);
//            properties.setProperty(key, value);
//        }
//        try {
//            ds.setFilters(filters);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ds.setConnectProperties(properties);

        return ds;
    }
}

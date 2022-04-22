package com.kashigin.stanislav.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ResourceBundle;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.kashigin.stanislav")
@PropertySource("classpath:/db.properties")
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        driver.setDriverClassName(resourceBundle.getString("DB_DRIVER"));
        driver.setUrl(resourceBundle.getString("DB_URL"));
        driver.setUsername(resourceBundle.getString("DB_USERNAME"));
        driver.setPassword(resourceBundle.getString("DB_PASSWORD"));
        return driver;
    }

}

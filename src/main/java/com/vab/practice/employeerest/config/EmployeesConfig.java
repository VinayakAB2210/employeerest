package com.vab.practice.employeerest.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class EmployeesConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getdataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate getjdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }
    
}

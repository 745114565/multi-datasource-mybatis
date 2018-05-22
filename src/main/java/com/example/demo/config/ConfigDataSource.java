package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public  class ConfigDataSource {
    @Bean("dataSourceUser")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.data1") // application.properteis中对应属性的前缀
    public DataSource dataSourceUser() {
        return DataSourceBuilder.create().build();
    }
    @Bean("dataSourceOrder")
    @ConfigurationProperties(prefix = "spring.datasource.data2") // application.properteis中对应属性的前缀
    public DataSource dataSourceOrder() {
        return DataSourceBuilder.create().build();
    }
}

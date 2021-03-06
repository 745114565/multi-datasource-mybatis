package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.user",sqlSessionFactoryRef = "sqlSessionFactoryUser")
public class MybatiesConfigUser {

    @Autowired
    @Qualifier("dataSourceUser")
    private DataSource dataSourceUser;

    @Bean("sqlSessionFactoryUser")
    @Primary
    public SqlSessionFactory sqlSessionFactoryUser() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceUser);
        return factoryBean.getObject();
    }
    @Bean("sqlSessionTemplateUser")
    @Primary
    public SqlSessionTemplate sqlSessionTemplateUser() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryUser());
        return template;
    }

}

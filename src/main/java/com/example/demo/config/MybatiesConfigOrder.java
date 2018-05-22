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
@MapperScan(basePackages = "com.example.demo.mapper.order",sqlSessionFactoryRef = "sqlSessionFactoryOrder")
public class MybatiesConfigOrder {

    @Autowired
    @Qualifier("dataSourceOrder")
    private DataSource dataSourceOrder;

    @Bean("sqlSessionFactoryOrder")
    @Primary
    public SqlSessionFactory sqlSessionFactoryOrder() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceOrder);
        return factoryBean.getObject();
    }
    @Bean("sqlSessionTemplateOrder")
    @Primary
    public SqlSessionTemplate sqlSessionTemplateOrder() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryOrder());
        return template;
    }

}

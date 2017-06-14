package com.huotu.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.naming.NamingException;

/**
 * Created by hxh on 2017-06-13.
 */
@Configuration
@ComponentScan(basePackages = "com.huotu")
@MapperScan(basePackages = "com.huotu")
public class RootConfig {
    private static String diver = "com.mysql.jdbc.Driver";

    private static String url = "jdbc:mysql://localhost:3306/buycat?useUnicode=true&characterEncoding=utf-8";

    private static String user = "root";

    private static String pwd = "hxh";

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(diver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws NamingException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext ap) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setTypeAliasesPackage("com.huotu");
        return sessionFactory;
    }
}

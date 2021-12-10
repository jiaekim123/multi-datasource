package com.multi.datasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class DataSourceProperties {

    @Bean(name = "userDataSource")
    @Qualifier("userDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.user")
    public DataSource userDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean(name = "shopDataSource")
    @Qualifier("shopDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.shop")
    public DataSource shopDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}

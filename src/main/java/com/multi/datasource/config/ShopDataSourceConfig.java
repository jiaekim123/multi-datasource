package com.multi.datasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "shopEntityManagerFactory",
        transactionManagerRef = "shopTransactionManager",
        basePackages = { "com.multi.datasource.repository.shop"}
)
public class ShopDataSourceConfig {

    @Autowired
    @Qualifier("shopDataSource")
    private DataSource shopDataSource;

    @Bean(name = "shopEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean shopEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(shopDataSource)
                .packages("com.multi.datasource.domain.shop")
                .persistenceUnit("shop")
                .build();
    }

    @Bean("shopTransactionManager")
    public PlatformTransactionManager shopTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(shopEntityManagerFactory(builder).getObject());
    }
}

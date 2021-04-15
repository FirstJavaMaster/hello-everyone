package com.tong.hellodoubledatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author matrix
 * @date
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorySecondary",
        transactionManagerRef = "transactionManagerSecondary",
        basePackages = {"com.tong.hellodoubledatasource.secondary.dao"})
public class SecondaryConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource dataSourceSecondary() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceSecondary())
                .properties(DataSourceConfig.getProperties())
                .packages("com.tong.hellodoubledatasource.secondary.entity")
                .persistenceUnit("secondary")
                .build();
    }


    @Bean
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }
}

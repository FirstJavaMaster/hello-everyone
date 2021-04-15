package com.tong.hellodoubledatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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

/**
 * @author ...
 * @date
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary",
        basePackages = {"com.tong.hellodoubledatasource.primary.dao"})
public class PrimaryConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource dataSourcePrimary() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourcePrimary())
                .properties(DataSourceConfig.getProperties())
                .packages("com.tong.hellodoubledatasource.primary.entity")
                .persistenceUnit("primary")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}

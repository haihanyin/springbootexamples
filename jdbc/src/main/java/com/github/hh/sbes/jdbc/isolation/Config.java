package com.github.hh.sbes.jdbc.isolation;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.concurrent.Semaphore;

@Configuration
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource getDataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        builder.setType(EmbeddedDatabaseType.H2).addScript("classpath:schema-isolation.sql");
//        return builder.build();
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/test")
                .username("root")
                .password("root")
                .build();
    }

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(getDataSource());
        return dataSourceTransactionManager;
    }

    @Bean
    public Semaphore getSemaphore() {
        return new Semaphore(0);
    }
}

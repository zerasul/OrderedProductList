package es.ind.ordercriteria.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    private static final MySQLContainer MYSQL_CONTAINER = new MySQLContainer("mysql:latest");

    static{
        MYSQL_CONTAINER.start();
    }
    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(MYSQL_CONTAINER.getUsername());
        dataSource.setPassword(MYSQL_CONTAINER.getPassword());
        dataSource.setJdbcUrl(MYSQL_CONTAINER.getJdbcUrl());

        return dataSource;
    }
}

package edu.eci.cvds.SearchLibrary.Config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "managementDataSource")
    public DataSource managementDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://taskmanagercvds1.mysql.database.azure.com:3306/flexibleserverdb?useSSL=true&requireSSL=false&autoReconnect=true&user=KUSER&password=4dm1nCVDS&serverTimezone=UTC ")
                .username("KUSER")
                .password("4dm1nCVDS")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
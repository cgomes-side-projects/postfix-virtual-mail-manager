package com.pvmm.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.pvmm")
public class AppDataBase extends WebMvcConfigurerAdapter {

    DriverManagerDataSource dataSource;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/postfix_mail_manager");
//        dataSource.setUsername("root");
//        dataSource.setPassword("P@ssw0rd");
        //dataSource.setUrl("jdbc:h2:mem:postfix;MODE=MYSQL;DATABASE_TO_UPPER=false;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;TRACE_LEVEL_FILE=2;INIT=CREATE SCHEMA IF NOT EXISTS \"public\";");
        dataSource.setUrl("jdbc:h2:mem:postfix;MODE=MYSQL;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1;TRACE_LEVEL_FILE=2;INIT=CREATE SCHEMA IF NOT EXISTS \"public\";");

        return dataSource;
    }

}

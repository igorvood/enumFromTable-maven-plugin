package ru.vood;

import org.apache.maven.plugins.annotations.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MainConfigurationTest {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    @Parameter(property = "username")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;


    @Bean("driverManagerDataSource")
    public DriverManagerDataSource driverManagerDataSource() {
        Properties prop = new Properties();
        prop.put("driverClassName", driverClassName);
        prop.put("username", username);
        prop.put("password", password);
        return new DriverManagerDataSource(url, prop);
    }

    @Bean("dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(driverManagerDataSource());
    }

    @Bean("jdbcTemplateMy")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(driverManagerDataSource());
    }

}

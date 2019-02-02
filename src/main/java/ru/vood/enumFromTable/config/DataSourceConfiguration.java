package ru.vood.enumFromTable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean("driverManagerDataSource")
    public DriverManagerDataSource driverManagerDataSource() {

/*        Properties prop = new Properties();
        prop.put("driverClassName", "oracle.jdbc.OracleDriver");
        prop.put("username", "vood");
        prop.put("password","vood");*/

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521:vood"/*, prop*/);
        return driverManagerDataSource;
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

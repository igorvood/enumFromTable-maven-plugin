package ru.vood.enumFromTable.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.DriverManagerDataSource
import java.util.*

@Configuration
open class DataSourceConfiguration {

    @Bean
    open fun driverManagerDataSource(): DriverManagerDataSource {
        val prop = Properties()
        prop["driverClassName"] = "oracle.jdbc.OracleDriver"
        prop["username"] = "vood"
        prop["password"] = "vood"
        return DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521:vood", prop)
    }

/*
    @Bean
    open fun entityManagerFactory():EntityManagerFactory{

    }
*/

    @Bean
    open fun dataSourceTransactionManager(): DataSourceTransactionManager {
        return DataSourceTransactionManager(driverManagerDataSource())
    }

}
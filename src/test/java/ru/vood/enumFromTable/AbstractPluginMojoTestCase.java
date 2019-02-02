package ru.vood.enumFromTable;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class AbstractPluginMojoTestCase extends AbstractMojoTestCase {
    private static AnnotationConfigApplicationContext ctx;

    protected void setUp() throws Exception {
        // required for mojo lookups to work
        super.setUp();
        if (ctx == null) {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
            DriverManagerDataSource driverManagerDataSource = ctx.getBean("driverManagerDataSource", DriverManagerDataSource.class);
            driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:vood");
            driverManagerDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
            driverManagerDataSource.setUsername("vood");
            driverManagerDataSource.setPassword("vood");
        }
    }

}

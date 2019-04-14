package ru.vood.enumFromTable;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.vood.enumFromTable.jaxb2.PluginParamsXml;
import ru.vood.enumFromTable.run.MainRunnable;

import java.io.File;

@Mojo(name = "setname", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class GenerateEnums extends AbstractMojo {

    @Parameter(property = "driverClassName")
    private String driverClassName;

    @Parameter(property = "username")
    private String username;

    @Parameter(property = "password")
    private String password;

    @Parameter(property = "url")
    private String url;

    @Parameter(property = "generatePackage")
    private String generatedPackage;

    @Parameter(property = "prefTable")
    private String prefTable;

    @Parameter(property = "propFile")
    private String propFile;

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Parameter
    private File configFile;

    private AnnotationConfigApplicationContext ctx;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        PluginParamsXml PluginParamsXml;


        getLog().info("+++++++++++++++++GenerateEnums++++++++++++++++++++++");
        //ctx = new AnnotationConfigApplicationContext("ru.vood.enumFromTable");
        ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);

        DriverManagerDataSource driverManagerDataSource = ctx.getBean("driverManagerDataSource", DriverManagerDataSource.class);

        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        getLog().info("+++++++++++++++++driverManagerDataSource++++++++++++++++++++++");

        MainRunnable mainRunnable = ctx.getBean("mainRunnable", MainRunnable.class);
        System.out.println(mainRunnable);
        mainRunnable.run(prefTable);

/*
        getLog().info("+++++++++++++++++refresh++++++++++++++++++++++");
        ctx.refresh();
*/

    }
}

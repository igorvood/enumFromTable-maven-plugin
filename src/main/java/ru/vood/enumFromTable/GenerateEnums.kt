package ru.vood.enumFromTable

import javassist.ClassPool
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.project.MavenProject
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.io.File


@Mojo(name = "setname", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
open class GenerateEnums : AbstractMojo() {
    @Parameter(property = "generatePackage")
    private val generatedPackage: String? = null

    @Parameter(property = "propFile")
    private val propFile: String? = null

    @Parameter(defaultValue = "\${project}", readonly = true)
    private val project: MavenProject? = null

    @Parameter
    private val configFile: File? = null

    private var ctx: AnnotationConfigApplicationContext? = null

    @Throws(MojoExecutionException::class)
    override fun execute() {

        ctx = AnnotationConfigApplicationContext("ru.vood.enumFromTable")
        ctx!!.refresh()
/*
        ctx = AnnotationConfigApplicationContext(MainConfiguration::class.java)
        ctx!!.refresh()
*/


        //val annotationConfigApplicationContext = AnnotationConfigApplicationContext(GenerateEnums::class.java)
        //println("annotationConfigApplicationContext $annotationConfigApplicationContext")
        this.pluginContext.entries.forEach { println("getPluginContext -> $it") }
        this.

        log.info("=============================Generate Enum from table==================")
        log.info("Generate to package $generatedPackage")
        log.info("Generate to package $propFile")

        log.info("Configuration $configFile")

        project!!.runtimeClasspathElements.forEach { println("runtimeClasspathElements -> $it") }

        log.info("artifacts -> ")
        project.artifacts.forEach { log.info("artifacts -> $it") }

        log.info("stringPropertyNames -> ")
        project.properties.stringPropertyNames().forEach { log.info("stringPropertyNames -> $it") }

        val pool = ClassPool.getDefault()

        for (cp in project.compileClasspathElements) {
            log.info("compileClasspathElements -> $cp")
            //pool.insertClassPath(cp)
        }


/*
        val pool = ClassPool.getDefault()
        try {
            for (cp in project!!.compileClasspathElements) {
                pool.insertClassPath(cp)
            }
            val ct = pool.get("ru.easyjava.maven.Target")
            val field = ct.getField("NAME")
            log.info(String.format("%s %s", name, field.constantValue))
        } catch (e: NotFoundException) {
            log.error(e)
            throw MojoExecutionException(e.message)
        } catch (e: DependencyResolutionRequiredException) {
            log.error(e)
            throw MojoExecutionException(e.message)
        }
*/

    }


}
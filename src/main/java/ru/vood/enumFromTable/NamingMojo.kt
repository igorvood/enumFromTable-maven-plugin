package ru.vood.enumFromTable

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.project.MavenProject

@Mojo(name = "setname", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
class NamingMojo : AbstractMojo() {
    @Parameter(property = "generatePackage")
    private val generatedPackage: String? = null

    @Parameter(defaultValue = "\${project}", readonly = true)
    private val project: MavenProject? = null

    @Throws(MojoExecutionException::class)
    override fun execute() {
        log.info("Generate Enum from table")
        log.info("Generate to package $generatedPackage")


/*
        val pool = ClassPool.getDefault()
        for (cp in project!!.compileClasspathElements) {
            //pool.insertClassPath(cp)
        }
*/


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
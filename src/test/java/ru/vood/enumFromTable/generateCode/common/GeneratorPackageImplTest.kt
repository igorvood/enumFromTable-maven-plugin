package ru.vood.enumFromTable.generateCode.common

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.PluginTunes
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MainConfiguration::class])
@ActiveProfiles("application.yml")
class GeneratorPackageImplTest {

    @Autowired
    lateinit var generatorPackageImpl: GeneratorPackageImpl

    @Autowired
    lateinit var pluginTunes: PluginTunes

    val table = Table.builder().tableName("TABLE_NAME").build()

    @Test
    fun genCode() {
        val valuesGeneratedClass = TypeOfGeneratedClass.values()
        var genCode: String
        valuesGeneratedClass.forEach {
            genCode = generatorPackageImpl.generateCode(table, it)
            Assert.assertEquals("package ${pluginTunes.packageIn}.${it.nameClass.toLowerCase()};\n\n", genCode)
        }

    }
}
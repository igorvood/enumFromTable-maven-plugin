package ru.vood.enumFromTable.generateCode.common

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration
import ru.vood.enumFromTable.generateCode.PluginTunes
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MainConfiguration::class])
@ActiveProfiles("application.yml")
class GeneratorCodeCommonFunctionTest {

    val DB_TABLE_NAME = "TABLE_NAME"
    @Autowired
    lateinit var generatorCodeCommonFunction: GeneratorCodeCommonFunction

    @Autowired
    lateinit var pluginTunes: PluginTunes


    @Test
    fun getTableName() {
        val tableName = generatorCodeCommonFunction.getTableName(DB_TABLE_NAME)
        Assert.assertEquals("${pluginTunes.prefixTable.toUpperCase()}_$DB_TABLE_NAME", tableName)
    }

    @Test
    fun getClassName() {
        var tableName: String
        val values = TypeOfGeneratedClass.values()
        val toCamelCase = generatorCodeCommonFunction.toCamelCase(pluginTunes.prefixTable)
        values.forEach {
            tableName = generatorCodeCommonFunction.getClassName(DB_TABLE_NAME, it)
            Assert.assertEquals("$toCamelCase${generatorCodeCommonFunction.toCamelCase(DB_TABLE_NAME)}${it.nameClass}", tableName)
        }
    }

    @Test
    fun getParameterName() {
        var tableName: String
        val values = TypeOfGeneratedClass.values()
        var toCamelCase = generatorCodeCommonFunction.toCamelCase(pluginTunes.prefixTable)
        toCamelCase = toCamelCase[0].toLowerCase() + toCamelCase.substring(1)
        values.forEach {
            tableName = generatorCodeCommonFunction.getParameterName(DB_TABLE_NAME, it)
            Assert.assertEquals("$toCamelCase${generatorCodeCommonFunction.toCamelCase(DB_TABLE_NAME)}${it.nameClass}Val", tableName)
            //Assert.assertEquals("${pluginTunes.prefixTable.toUpperCase()}_$DB_TABLE_NAME", tableName)
        }
    }

    @Test
    fun getPackageName() {
        var tableName: String
        val values = TypeOfGeneratedClass.values()
        values.forEach {
            tableName = generatorCodeCommonFunction.getPackageName(it)
            Assert.assertEquals("${pluginTunes.packageIn}.${it.nameClass.toLowerCase()}", tableName)
        }
    }

    @Test
    fun getFullClassName() {
        var tableName: String
        val values = TypeOfGeneratedClass.values()
        values.forEach {
            tableName = generatorCodeCommonFunction.getFullClassName(DB_TABLE_NAME, it)
            Assert.assertEquals("${generatorCodeCommonFunction.getPackageName(it)}.${generatorCodeCommonFunction.getClassName(DB_TABLE_NAME, it)}", tableName)
        }
    }

    @Test
    fun genFieldName() {
        val tableName = generatorCodeCommonFunction.genFieldName(DB_TABLE_NAME)
        var toCamelCase = generatorCodeCommonFunction.toCamelCase(DB_TABLE_NAME)
        toCamelCase = toCamelCase[0].toLowerCase() + toCamelCase.substring(1)
        Assert.assertEquals(toCamelCase, tableName)
    }

    @Test
    fun toCamelCase() {
        val tableName = generatorCodeCommonFunction.toCamelCase(DB_TABLE_NAME)
        Assert.assertEquals("TableName", tableName)
    }

    @Test
    fun getPluginTunes() {
    }

    @Test
    fun setPluginTunes() {
    }
}
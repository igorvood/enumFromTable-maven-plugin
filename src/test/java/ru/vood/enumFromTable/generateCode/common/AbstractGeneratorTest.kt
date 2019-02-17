package ru.vood.enumFromTable.generateCode.common

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
abstract class AbstractGeneratorTest {
    @Autowired
    lateinit var pluginTunes: PluginTunes

    @Autowired
    lateinit var generatorCodeCommonFunction: GeneratorCodeCommonFunction

    val table = Table.builder().tableName("TABLE_NAME").build()

    val valuesTypeOfGeneratedClass = TypeOfGeneratedClass.values()

    val DB_TABLE_NAME = "TABLE_NAME"

}
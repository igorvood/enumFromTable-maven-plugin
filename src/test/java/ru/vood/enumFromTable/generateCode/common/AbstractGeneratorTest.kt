package ru.vood.enumFromTable.generateCode.common

import org.springframework.beans.factory.annotation.Autowired
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.PluginTunes
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass

open abstract class AbstractGeneratorTest {
    @Autowired
    lateinit var pluginTunes: PluginTunes

    @Autowired
    lateinit var generatorCodeCommonFunction: GeneratorCodeCommonFunction

    val table = Table.builder().tableName("TABLE_NAME").build()

    val valuesTypeOfGeneratedClass = TypeOfGeneratedClass.values()

    val DB_TABLE_NAME = "TABLE_NAME"

}
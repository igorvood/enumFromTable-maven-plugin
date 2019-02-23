package ru.vood.enumFromTable.generateCode.common

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration
import ru.vood.enumFromTable.entity.Column
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.enums.DataType
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

    val DB_TABLE_NAME = "TABLE_NAME"

    val columnDate: Column = Column.builder()
            .tableName(DB_TABLE_NAME)
            .columnName("column_Date")
            .dataType(DataType.DATE)
            .build()

    val columnTimestamp: Column = Column.builder()
            .tableName(DB_TABLE_NAME)
            .columnName("column_Timestamp")
            .dataType(DataType.TIMESTAMP)
            .build()

    val columnNumber: Column = Column.builder()
            .tableName(DB_TABLE_NAME)
            .columnName("column_Number")
            .dataType(DataType.NUMBER)
            .build()
    val columnVarchar: Column = Column.builder()
            .tableName(DB_TABLE_NAME)
            .columnName("column_Varchar")
            .dataType(DataType.VARCHAR2)
            .build()

    val table = Table.builder()
            .tableName(DB_TABLE_NAME)
            .columns(
                    arrayListOf(
                            columnNumber,
                            columnVarchar,
                            columnDate,
                            columnTimestamp
                    )
            )
            .build()

    val valuesTypeOfGeneratedClass = TypeOfGeneratedClass.values()


}
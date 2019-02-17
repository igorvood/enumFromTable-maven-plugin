package ru.vood.enumFromTable.generateCode.common

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.intf.GeneratorPartOfObject


@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MainConfiguration::class])
@ActiveProfiles("application.yml")
class GeneratingAllTest : AbstractGeneratorTest() {

    @Autowired
    lateinit var allGenerators: List<GeneratorPartOfObject<Table>>

    @Test
    fun generateCode() {
        println("==============================================")
        allGenerators.forEach { print(it.generateCode(table, TypeOfGeneratedClass.ENUM_CLASS)) }
        println("==============================================")
    }
}
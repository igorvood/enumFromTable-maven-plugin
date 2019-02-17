package ru.vood.enumFromTable.generateCode.enums

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.common.AbstractGeneratorTest

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MainConfiguration::class])
@ActiveProfiles("application.yml")
class GeneratorEnumImplementationTest : AbstractGeneratorTest() {

    @Autowired
    lateinit var generatorEnumImplementation: GeneratorEnumImplementation

    @Test
    fun generateCode() {
        val generateCode = generatorEnumImplementation.generateCode(table, TypeOfGeneratedClass.ENUM_CLASS)
        Assert.assertEquals(" implements CommonEnumInterface<${generatorCodeCommonFunction.getClassName(DB_TABLE_NAME, TypeOfGeneratedClass.ENUM_CLASS)}>", generateCode)
    }

    @Test
    fun generateCodeError() {
        val noEnum = valuesTypeOfGeneratedClass.asSequence()
                .filter { it != TypeOfGeneratedClass.ENUM_CLASS }
                .toList()
        noEnum.forEach {
            try {
                generatorEnumImplementation.generateCode(table, it)
                Assert.assertFalse("Test Failed", true)
            } catch (e: IllegalStateException) {
                Assert.assertEquals("Класс можно использовать только для генерации Enum, генератор вызван для $it", e.message)
            }
        }
    }

}
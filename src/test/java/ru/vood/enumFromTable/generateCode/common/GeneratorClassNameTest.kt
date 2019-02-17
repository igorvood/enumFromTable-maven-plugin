package ru.vood.enumFromTable.generateCode.common

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MainConfiguration::class])
@ActiveProfiles("application.yml")
class GeneratorClassNameTest : AbstractGeneratorTest() {

    @Autowired
    lateinit var generatorClassName: GeneratorClassName

    @Test
    fun generateCode() {
        valuesTypeOfGeneratedClass.forEach {
            val generateCode = generatorClassName.generateCode(table, it)
            Assert.assertEquals("${it.classModifierJava} ${generatorCodeCommonFunction.getClassName(DB_TABLE_NAME, it)}\n", generateCode)
        }
    }
}
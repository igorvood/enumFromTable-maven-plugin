package ru.vood.enumFromTable.generateCode.enums

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

class GeneratorEnumFullClassTest : AbstractGeneratorTest() {

    @Autowired
    lateinit var generatorEnumFullClass: GeneratorEnumFullClass

    @Test
    fun generateCode() {
        val generateCode = generatorEnumFullClass.generateCode(table, TypeOfGeneratedClass.ENUM_CLASS)
        println(generateCode)
    }
}
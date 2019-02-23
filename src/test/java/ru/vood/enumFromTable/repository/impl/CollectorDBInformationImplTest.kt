package ru.vood.enumFromTable.repository.impl

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import ru.vood.enumFromTable.MainConfiguration
import ru.vood.enumFromTable.generateCode.common.AbstractGeneratorTest

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [MainConfiguration::class])
@ActiveProfiles("application.yml")
class CollectorDBInformationImplTest : AbstractGeneratorTest() {

    @Autowired
    lateinit var collectorDBInformationImpl: CollectorDBInformationImpl

    @Test
    fun getTables() {
        collectorDBInformationImpl.getTables("V_BD_OBJECT_T")
    }
}
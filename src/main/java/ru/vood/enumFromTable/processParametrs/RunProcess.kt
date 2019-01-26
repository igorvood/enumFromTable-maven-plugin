package ru.vood.enumFromTable.processParametrs

import org.apache.maven.plugin.logging.SystemStreamLog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class RunProcess : CommandLineRunner {

    @Autowired
    val processParameterInterface: List<ProcessParameterInterface>? = null

    private val log = SystemStreamLog()

    override fun run(vararg args: String?) {
        log.info("=============================RunProcess==================")
        processParameterInterface?.forEach { println("processes param -> ${it.javaClass}") }

    }


}
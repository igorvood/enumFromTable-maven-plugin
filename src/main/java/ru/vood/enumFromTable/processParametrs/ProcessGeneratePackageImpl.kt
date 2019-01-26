package ru.vood.enumFromTable.processParametrs

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service

@Service
@Order(1)
class ProcessGeneratePackageImpl : ProcessParameterInterface {
    override fun process(param: Parameters, value: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
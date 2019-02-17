package ru.vood.enumFromTable.generateCode.common

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass

@Component
@Order(30)

class GeneratorClassName(generatorCodeCommonFunction: GeneratorCodeCommonFunction)
    : AbstractGenerator<Table>(generatorCodeCommonFunction) {

    override fun generateCode(dbObject: Table, typeOfGenClass: TypeOfGeneratedClass): String {
        return "${typeOfGenClass.classModifierJava} ${generatorCodeCommonFunction.getClassName(dbObject.getName(), typeOfGenClass)}\n"
    }
}

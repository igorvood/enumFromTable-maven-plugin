package ru.vood.enumFromTable.generateCode.enums

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Column
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.common.AbstractGenerator
import ru.vood.enumFromTable.generateCode.common.GeneratorCodeCommonFunction

@Component
@Order(50)
class GeneratorEnumField(generatorCodeCommonFunction: GeneratorCodeCommonFunction)
    : AbstractGenerator<Column>(generatorCodeCommonFunction) {

    override fun generateCode(dbObject: Column, typeOfGenClass: TypeOfGeneratedClass): String {
        return "public final ${dbObject.dataType.clazz.name} ${generatorCodeCommonFunction.genFieldName(dbObject.getName())}"
    }
}
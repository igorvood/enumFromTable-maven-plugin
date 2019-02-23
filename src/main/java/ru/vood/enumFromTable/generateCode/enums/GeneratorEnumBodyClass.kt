package ru.vood.enumFromTable.generateCode.enums

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.intf.GeneratorBodyClass
import ru.vood.enumFromTable.generateCode.intf.GeneratorField

@Component
@Order(40)
class GeneratorEnumBodyClass(
        //generatorCodeCommonFunction: GeneratorCodeCommonFunction,
        @Qualifier("generatorEnumField")
        val generatorField: GeneratorField

) :// AbstractGeneratorBodyClass(generatorCodeCommonFunction)
        GeneratorBodyClass {

    override fun generateCode(dbObject: Table, typeOfGenClass: TypeOfGeneratedClass): String {
        var reduce: String = dbObject.columns.asSequence()
                .map { "    ${generatorField.generateCode(it, typeOfGenClass)}" }
                .reduce { s, s1 -> s + s1 }
        return """{
$reduce
}"""
    }
}
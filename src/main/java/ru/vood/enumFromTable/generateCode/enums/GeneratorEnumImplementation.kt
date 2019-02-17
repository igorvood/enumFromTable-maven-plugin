package ru.vood.enumFromTable.generateCode.enums

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.common.GeneratorCodeCommonFunction
import ru.vood.enumFromTable.generateCode.intf.AbstractImplementationGenerator

@Component
@Order(35)
class GeneratorEnumImplementation(generatorCodeCommonFunction: GeneratorCodeCommonFunction) : AbstractImplementationGenerator(generatorCodeCommonFunction) {
    //    CommonEnumInterface<DataType>
    override fun generateCode(dbObject: Table, typeOfGenClass: TypeOfGeneratedClass): String {
        if (typeOfGenClass != TypeOfGeneratedClass.ENUM_CLASS)
            throw IllegalStateException("Класс можно использовать только для генерации Enum, генератор вызван для $typeOfGenClass")
        return " implements CommonEnumInterface<${generatorCodeCommonFunction.getClassName(dbObject.tableName, TypeOfGeneratedClass.ENUM_CLASS)}>"
    }
}
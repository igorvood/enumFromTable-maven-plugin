package ru.vood.enumFromTable.generateCode.enums

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.common.GeneratorCodeCommonFunction
import ru.vood.enumFromTable.generateCode.intf.AbstractGeneratorFullClass
import ru.vood.enumFromTable.generateCode.intf.GeneratorBodyClass
import ru.vood.enumFromTable.generateCode.intf.GeneratorImplementation
import ru.vood.enumFromTable.generateCode.intf.GeneratorPartOfObject

@Component
class GeneratorEnumFullClass(
        generatorCodeCommonFunction: GeneratorCodeCommonFunction,
//                             @Autowired
//                             listGenerators: List<GeneratorPartOfObject<Table>>,
        @Qualifier("generatorPackageImpl")
        val packageG: GeneratorPartOfObject<Table>,
        @Qualifier("generatorClassName")
        val classNameG: GeneratorPartOfObject<Table>,
        @Qualifier("generatorEnumImplementation")
        val generatorImplementation: GeneratorImplementation,
        @Qualifier("generatorEnumBodyClass")
        val generatorBodyClass: GeneratorBodyClass


) : AbstractGeneratorFullClass(generatorCodeCommonFunction) {
    //    val genNames = arrayListOf("generatorPackageImpl")
    override fun generateCode(dbObject: Table, typeOfGenClass: TypeOfGeneratedClass): String {
        return packageG.generateCode(dbObject, typeOfGenClass) +
                classNameG.generateCode(dbObject, typeOfGenClass) +
                generatorImplementation.generateCode(dbObject, typeOfGenClass) +
                generatorBodyClass.generateCode(dbObject, typeOfGenClass)

    }
}
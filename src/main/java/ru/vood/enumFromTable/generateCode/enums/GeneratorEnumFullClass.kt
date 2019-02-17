package ru.vood.enumFromTable.generateCode.enums

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass
import ru.vood.enumFromTable.generateCode.common.GeneratorCodeCommonFunction
import ru.vood.enumFromTable.generateCode.intf.AbstractGeneratorFullClass
import ru.vood.enumFromTable.generateCode.intf.GeneratorPartOfObject

@Component
class GeneratorEnumFullClass(generatorCodeCommonFunction: GeneratorCodeCommonFunction,
//                             @Autowired
//                             listGenerators: List<GeneratorPartOfObject<Table>>,
                             @Autowired
                             @Qualifier("generatorPackageImpl")
                             val packageG: GeneratorPartOfObject<Table>,
                             @Autowired
                             @Qualifier("generatorClassName")
                             val classNameG: GeneratorPartOfObject<Table>) : AbstractGeneratorFullClass(generatorCodeCommonFunction) {
    //    val genNames = arrayListOf("generatorPackageImpl")
    override fun generateCode(dbObject: Table, typeOfGenClass: TypeOfGeneratedClass): String {
        return packageG.generateCode(dbObject, typeOfGenClass) + classNameG.generateCode(dbObject, typeOfGenClass)
    }
}
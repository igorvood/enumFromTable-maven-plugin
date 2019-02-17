package ru.vood.enumFromTable.generateCode.common

import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.DataBaseObject
import ru.vood.enumFromTable.generateCode.intf.GeneratorPartOfObject

@Component
abstract class AbstractGenerator<Q : DataBaseObject>(var generatorCodeCommonFunction: GeneratorCodeCommonFunction)
    : GeneratorPartOfObject<Q> {


}
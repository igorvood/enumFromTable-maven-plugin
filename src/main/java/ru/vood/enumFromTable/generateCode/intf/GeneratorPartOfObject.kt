package ru.vood.enumFromTable.generateCode.intf

import ru.vood.enumFromTable.entity.DataBaseObject
import ru.vood.enumFromTable.generateCode.TypeOfGeneratedClass

interface GeneratorPartOfObject<Q : DataBaseObject> {

    fun generateCode(dbObject: Q, typeOfGenClass: TypeOfGeneratedClass = TypeOfGeneratedClass.ENTITY_CLASS): String

}
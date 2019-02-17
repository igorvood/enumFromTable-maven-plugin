package ru.vood.enumFromTable.generateCode.intf

import org.springframework.stereotype.Component
import ru.vood.enumFromTable.generateCode.common.GeneratorCodeCommonFunction

@Component
abstract class AbstractGeneratorFullClass(var generatorCodeCommonFunction: GeneratorCodeCommonFunction)
    : GeneratorFullClass
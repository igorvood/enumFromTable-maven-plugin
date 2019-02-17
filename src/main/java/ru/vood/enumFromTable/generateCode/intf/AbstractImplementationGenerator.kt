package ru.vood.enumFromTable.generateCode.intf

import org.springframework.stereotype.Component
import ru.vood.enumFromTable.generateCode.common.GeneratorCodeCommonFunction

@Component
abstract class AbstractImplementationGenerator(var generatorCodeCommonFunction: GeneratorCodeCommonFunction)
    : GeneratorImplementation
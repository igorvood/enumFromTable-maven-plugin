package ru.vood.enumFromTable.repository.impl

import org.springframework.stereotype.Service
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.repository.CollectorDBInformation
import ru.vood.enumFromTable.repository.TableInfoInterface
import ru.vood.enumFromTable.repository.ValuesFiller

@Service
class CollectorDBInformationImpl(var tableInfoInterface: TableInfoInterface,
                                 var valuesFiller: ValuesFiller

) : CollectorDBInformation {
    override fun getTables(prefix: String): List<Table> {
        val tables = tableInfoInterface.getTables(prefix)
        val tablesAndCol = tables.asSequence()
                .map {
                    Table(it, tableInfoInterface.getTablesPKColumns(it))
                }
                .toList()
        return tablesAndCol
                .asSequence()
                .map {
                    valuesFiller.fill(it)
                }
                .toList()
    }
}
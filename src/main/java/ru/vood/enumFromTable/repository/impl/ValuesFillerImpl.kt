package ru.vood.enumFromTable.repository.impl

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import ru.vood.enumFromTable.entity.Table
import ru.vood.enumFromTable.repository.ValuesFiller

@Component
class ValuesFillerImpl(val jdbcTemplate: JdbcTemplate) : ValuesFiller {
    fun buildSelect(table: Table): String {
        val reduce = table.columns.asSequence()
                .map { it.columnName }
                .reduce { c1, c2 -> "$c1, $c2" }

        return "select $reduce from ${table.tableName} where rownum=1"
    }

    override fun fill(table: Table): Table {
        jdbcTemplate.queryForList<>()
        val queryForMap = jdbcTemplate.queryForMap(buildSelect(table))

        println(queryForMap)
        return table
    }

}
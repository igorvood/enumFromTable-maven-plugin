package ru.vood.enumFromTable.repository

import ru.vood.enumFromTable.entity.Table

interface CollectorDBInformation {

    fun getTables(prefix: String): List<Table>
}
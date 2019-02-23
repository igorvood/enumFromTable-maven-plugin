package ru.vood.enumFromTable.repository

import ru.vood.enumFromTable.entity.Table

interface ValuesFiller {

    fun fill(table: Table): Table
}
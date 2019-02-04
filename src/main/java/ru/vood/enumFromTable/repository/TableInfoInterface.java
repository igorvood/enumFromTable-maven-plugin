package ru.vood.enumFromTable.repository;

import ru.vood.enumFromTable.entity.Column;
import ru.vood.enumFromTable.entity.Index;

import java.util.List;

public interface TableInfoInterface {

    List<String> getTables(String prefix);

    List<Column> getTableColumns(String tableName);

    List<Index> getTablePKColumns(String tableName);

    List<Column> getTablesPKColumns(String prefix);
}

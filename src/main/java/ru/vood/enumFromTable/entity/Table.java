package ru.vood.enumFromTable.entity;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Table {
    private final String tableName;
    private List<Column> columns;
}

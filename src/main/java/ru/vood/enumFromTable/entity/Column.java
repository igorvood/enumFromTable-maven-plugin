package ru.vood.enumFromTable.entity;


import lombok.Builder;
import lombok.Value;
import ru.vood.enumFromTable.enums.DataType;

@Builder
@Value
public class Column {
    private final String tableName;
    private final String columnName;
    private final DataType dataType;
}

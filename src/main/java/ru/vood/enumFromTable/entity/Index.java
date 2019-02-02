package ru.vood.enumFromTable.entity;


import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Index {
    private final String tableName;
    private final String columnName;
}

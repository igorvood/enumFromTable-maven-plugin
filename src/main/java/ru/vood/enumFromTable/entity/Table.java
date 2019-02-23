package ru.vood.enumFromTable.entity;

import lombok.Builder;
import lombok.NonNull;

import java.util.List;

@Builder
//@Value
//@Data
//@AllArgsConstructor
public class Table implements DataBaseObject {

    @NonNull
    public final String tableName;
    @NonNull
    public final List<Column> columns;

    public Table(String tableName, List<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    @NonNull
    @Override
    public String getName() {
        return tableName;
    }
}

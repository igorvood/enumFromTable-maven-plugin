package ru.vood.enumFromTable.entity;


import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Builder
@Value
public class Index implements DataBaseObject {
    private final String indexName;
    private final String tableName;
    private final String columnName;

    @NotNull
    @Override
    public String getName() {
        return indexName;
    }
}

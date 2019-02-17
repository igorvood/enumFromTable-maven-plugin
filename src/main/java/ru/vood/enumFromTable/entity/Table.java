package ru.vood.enumFromTable.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Builder
@Value
@Data
public class Table implements DataBaseObject {
    private final String tableName;
    private List<Column> columns;

    @NotNull
    @Override
    public String getName() {
        return tableName;
    }
}

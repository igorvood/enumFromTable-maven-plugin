package ru.vood.enumFromTable.entity;


import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import ru.vood.enumFromTable.enums.DataType;

@Builder
@Value
public class Column implements DataBaseObject {
    private final String tableName;
    private final String columnName;
    private final DataType dataType;
    private final boolean isPKColumn;

    @NotNull
    @Override
    public String getName() {
        return columnName;
    }
}

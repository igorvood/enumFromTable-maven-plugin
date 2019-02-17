package ru.vood.enumFromTable.entity;


import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import ru.vood.enumFromTable.enums.DataType;

@Builder
@Value
public class Column implements DataBaseObject {
    public final String tableName;
    public final String columnName;
    public final DataType dataType;
    public final boolean isPKColumn;

    @NotNull
    @Override
    public String getName() {
        return columnName;
    }
}

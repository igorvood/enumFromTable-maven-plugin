package ru.vood.enumFromTable.entity;


import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import ru.vood.enumFromTable.enums.DataType;

@Builder
@Value
public class Column implements DataBaseObject {
    @NonNull
    public final String tableName;
    @NonNull
    public final String columnName;
    @NonNull
    public final DataType dataType;
    public final boolean isPKColumn;
    public Values values;

    @Override
    public String getName() {
        return columnName;
    }
}

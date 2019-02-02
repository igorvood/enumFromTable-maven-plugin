package ru.vood.enumFromTable.enums;

public enum DataType implements CommonEnumInterface<DataType> {
    NUMBER,
    VARCHAR2;

    public static DataType getEnum(String name) {
        return CommonEnumInterface.getEnumByName(name, DataType.class, VARCHAR2, DataType::values);
    }
}

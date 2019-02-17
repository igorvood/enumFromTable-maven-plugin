package ru.vood.enumFromTable.enums;

public enum DataType implements CommonEnumInterface<DataType> {

    NUMBER(Long.class),
    VARCHAR2(String.class);

    public final Class clazz;

    DataType(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static DataType getEnum(String name) {
        return CommonEnumInterface.getEnumByName(name, DataType.class, VARCHAR2, DataType::values);
    }
}

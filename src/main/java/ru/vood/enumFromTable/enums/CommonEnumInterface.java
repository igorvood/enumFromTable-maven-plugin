package ru.vood.enumFromTable.enums;

import java.util.Arrays;
import java.util.function.Supplier;

public interface CommonEnumInterface<T extends CommonEnumInterface> {

    static <T extends CommonEnumInterface> T getEnumByName(String name, Class<T> aClass, T defaultValue, Supplier<T[]> supplier) {
        if (name == null || name.isEmpty()) return defaultValue;
        return Arrays.stream(supplier.get())
                .filter(e -> e.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(getException(aClass, name));
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(pure = true)
    static <T extends CommonEnumInterface> Supplier<RuntimeException> getException(Class<T> aClass, String name) {
        return () -> new RuntimeException("В перечислении " + aClass.getName() + " не найден экземпляр " + name);
    }

}

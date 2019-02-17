package ru.vood.enumFromTable.generateCode

enum class TypeOfGeneratedClass(val nameClass: String, val comment: String, val classModifierJava: String, val listAnnotation: List<Class<Any>>) {

    GRID_CLASS("Grid", "Таблица", "public class", arrayListOf()),
    EDITOR_CLASS("Editor", "Редактор", "public class", arrayListOf()),

    ENTITY_CLASS("Entity", "Сущность", "public class", arrayListOf()),
    IMPL_CLASS("Impl", "Репозиторий", "public class", arrayListOf()),
    SERVICE_CLASS("Service", "Интерфейс", "public class", arrayListOf()),
    ENUM_CLASS("Enum", "Перечисление", "public enum", arrayListOf()),
    REPOSITORY_CLASS("Repository", "Репозиторий", "public class", arrayListOf());

    override fun toString(): String {
        return "$nameClass"
    }
}

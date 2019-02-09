package ru.vood.enumFromTable.generateCode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GenCodeCommonFunction(@Autowired
                            var pluginTunes: PluginTunes) {

    fun getTableName(dbTableName: String) = (pluginTunes.prefixTable + dbTableName).toUpperCase()

    @JvmOverloads
    fun getClassName(dbTableName: String, typeOfGeneratedClass: TypeOfGeneratedClass = TypeOfGeneratedClass.ENTITY_CLASS) = toCamelCase(getTableName(dbTableName) + "_" + typeOfGeneratedClass)


    @JvmOverloads
    fun getParameterName(dbName: String, typeOfGeneratedClass: TypeOfGeneratedClass = TypeOfGeneratedClass.ENTITY_CLASS): String {
        val parameterName = getClassName(dbName, typeOfGeneratedClass)
        return parameterName[0].toLowerCase() + parameterName.substring(1) + "Val"
    }

    fun getPackageName(typeOfGeneratedClass: TypeOfGeneratedClass) = pluginTunes.packageIn + "." + typeOfGeneratedClass.toString().toLowerCase()

    @JvmOverloads
    fun getFullClassName(dbName: String
                         , typeOfGeneratedClass: TypeOfGeneratedClass = TypeOfGeneratedClass.ENTITY_CLASS): String {
        val code = StringBuilder(getPackageName(typeOfGeneratedClass)).append(".")
        return code.append(getClassName(dbName, typeOfGeneratedClass)).toString()
    }

    fun genFieldName(dbName: String): String {
        val s = toCamelCase(dbName)
        return s[0].toLowerCase() + s.substring(1)
    }

/*
    @JvmOverloads
    fun isRootEntity(
            entity: VBdObjectEntity,
            typeOfGenClassKT: TypeOfGenClass = TypeOfGenClass.ENTITY_CLASS
    ): Boolean {
        return if (typeOfGenClassKT == TypeOfGenClass.ENTITY_CLASS) {
            entity.parent != null && RootObjects.isRoot(entity.parent) */
/*&& entity.parent.typeObject.equals(ObjectTypes.getTABLE())*//*

        } else false
    }
*/

/*
    @JvmOverloads
    fun getExtendsClassName(entity: VBdObjectEntity, typeOfGenClassKT: TypeOfGenClass = TypeOfGenClass.ENTITY_CLASS): StringBuilder {
        val code = StringBuilder("")
        return if (!isRootEntity(entity, typeOfGenClassKT)) {
            code.append(" : ").append(getFullClassName(entity.parent, typeOfGenClassKT)).append("()")
        } else code
    }
*/


    fun toCamelCase(s: String): String {
        val ret = StringBuilder(s.length)
        for (word in s.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if (!word.isEmpty()) {
                ret.append(word.substring(0, 1).toUpperCase())
                ret.append(word.substring(1).toLowerCase())
            }
        }
        return ret.toString()
    }

}
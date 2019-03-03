package ru.vood.admplugin.infrastructure.generateCode.impl.createFiles

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class GenerateOneFile {

    @JvmOverloads
    fun createFile(startPath: Path, packageName: String, fileName: String, fileBody: StringBuilder) {
        val path = Paths.get("${createDirs(startPath, packageName)}\\$fileName")
        Files.write(path, fileBody.lines(), Charset.forName("UTF-8"), StandardOpenOption.CREATE)
    }

    private fun createDirs(startPath: Path, packageName: String): Path {
        val beginDir = startPath.toString() //todo убрать это позже,
        val dirs = beginDir + "\\" + packageName.replace(".", "\\")
        val dir = Files.createDirectories(Paths.get(dirs))
        return dir
    }

}
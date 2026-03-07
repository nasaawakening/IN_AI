package com.inai.explorer

import java.io.File

object ProjectExplorer {

fun listFiles(path:String):List<File>{

return File(path).listFiles()?.toList() ?: emptyList()

}

}
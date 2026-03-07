package com.inai.runner

object PythonRunner {

fun run(code:String){

val process = Runtime
.getRuntime()
.exec("python")

process.outputStream.write(
code.toByteArray()
)

}

}
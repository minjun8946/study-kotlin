package com.example.kotlininaction.chapter6

import java.io.BufferedReader
import java.lang.NumberFormatException

//6.3.1
fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        }catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}
// List<Int?>는 리스트 안의 각 값이 널이 될 수 있는 것이다.
// List<Int>?는 전체 리스트가 널이 될 수 있는 것이다.
// List<Int?>?는 경우에 따라 널이 될 수 있는 리스트이다.

fun main(args: Array<String>){
    for (i in args.indices){
        val strings = listOf("a","b","c")
        println("%s/%s/%s".format(*strings.toTypedArray()))
    }
}
// format 함수의 파라미터 vararg를 사용하기 위해 * 스프레드 연산자를 써야한다
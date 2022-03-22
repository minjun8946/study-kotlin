package com.example.kotlininaction.chapter2

import android.icu.number.IntegerWidth
import java.io.BufferedReader
import java.lang.NumberFormatException

//2.5.1
fun readNumber(reader: BufferedReader): Int?{
    return try {
        val line = reader.readLine()
        Integer.parseInt(line)
    }catch (e: NumberFormatException){
        null
    }finally {
        reader.close()
    }
}
// kotlin 의 예외처리는 try, catch, finally로 한다.

//2.5.2

fun readNumber2(reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e: NumberFormatException){
        null
    }
    println(number)
}
// try를 식으로도 사용할 수 있다.
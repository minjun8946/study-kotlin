package com.example.kotlinpractice1

fun main(){
    println(type(3.23))
}
inline fun <reified  T> type(a : T) : T{
    return when(T::class){
        String::class -> "StringClass" as T
        else -> "Not string, Not Integer" as T
    }
}
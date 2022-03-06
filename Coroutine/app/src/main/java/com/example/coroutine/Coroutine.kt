package com.example.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun foo(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    val a = flowOf(1,2).runningFold(emptyList<Int>()) { acc, value -> acc + value}.toList()
    val b = flowOf(1,2).scan(listOf(1)) {acc : List<Int>, value: Int -> acc + value}.toList()

    println(a)
    println(b)
}

suspend fun a() {
    delay(1000)
    println("aaaaa")
}

suspend fun b() {
    println("bbbb")
}
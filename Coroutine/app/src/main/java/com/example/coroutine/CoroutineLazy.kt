package com.example.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() = runBlocking {

    val time = measureTimeMillis {
        val one = async { doWork1() }
        val two = async(start = CoroutineStart.LAZY) { doWork2() }
        println("${one.await()} + _ ${two.await()}")
    }
    println(time)
}

suspend fun doWork1(): String{
    delay(1000)
    return "Work1"
}
suspend fun doWork2(): String{
    delay(3000)
    return "Work2"
}
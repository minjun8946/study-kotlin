package com.example.kotlinpractice1

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
    runBlocking {
        val exeTime = longRunningTsk()
        println("Execution Time is $exeTime")
    }
}

suspend fun longRunningTsk(): Long {
    return measureTimeMillis {
        println("Please wait")
        delay(200)
        println("Delay Over")
    }
}

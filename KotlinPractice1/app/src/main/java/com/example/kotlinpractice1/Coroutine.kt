package com.example.kotlinpractice1

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlin.system.measureTimeMillis

@DelicateCoroutinesApi
fun main(){
    a()
    b()
}



 fun a(){
    Thread.sleep(2000)
    println("bbbb")
}

fun b(){
    println("b")
}

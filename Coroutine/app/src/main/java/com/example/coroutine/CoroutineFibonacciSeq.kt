package com.example.coroutine

fun main(){
    println(fibonacciSeq.take(7).toList())
}
val fibonacciSeq = sequence {
    val start = 0
    yield(start)
    yieldAll(1..5 step 2)
    yieldAll(generateSequence(8) {it * 3})
}


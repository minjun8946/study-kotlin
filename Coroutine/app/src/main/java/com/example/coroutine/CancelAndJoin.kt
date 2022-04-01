package com.example.coroutine

import kotlinx.coroutines.*

fun main()= runBlocking {
    val job = launch {
        try {
            repeat(1000){ i ->
                println(i)
                delay(500)
            }
        }finally {
            withContext(NonCancellable){
                println("finally")
                delay(1000)
                println("delay")
            }
        }
    }
    delay(1300)
    job.cancelAndJoin()
    println("main")
}
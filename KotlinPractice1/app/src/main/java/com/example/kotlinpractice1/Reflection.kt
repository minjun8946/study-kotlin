package com.example.kotlinpractice1

import kotlin.reflect.KClass

fun main(){
    val sabarada = Sabarada(5)
    val kClass: KClass<out Sabarada> = sabarada::class
    kClass.

}

class Sabarada(
    private val first: Int
) {
    private val immutableSecret: Int = 2

    private var mutableSecret: Int = 3

    fun make(second: Int): Int {
        return first + second
    }

    private fun secretMake(): Int {
        return immutableSecret + mutableSecret
    }
}


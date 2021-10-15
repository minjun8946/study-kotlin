package com.example.kotlinpractice1

fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main() {
    val fruitsBasket1 = Array<Apple>(3) { _ -> Apple() }
    val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
    copyFromTo(fruitsBasket1, fruitsBasket2)
    val myString = MyString()
    myString add "Hello"
    myString add "World"
    myString add "Kotlin"
    println(myString.string)
    val a = 1
    val b = 2
    plus(a,b)
}

fun receiveFruits(fruits: Array<Fruit>) {
    fruits[0] = Banana() // 문제가 될 수 있음!
}

class MyString {
    var string = ""
    infix fun add(other: String) {
        this.string = this.string + other
    }


}
fun <T,V>plus(one : T, two :V)  {
    println(one.toString() + two.toString())
}
open class Fruit
class Apple : Fruit()
class Banana : Fruit()

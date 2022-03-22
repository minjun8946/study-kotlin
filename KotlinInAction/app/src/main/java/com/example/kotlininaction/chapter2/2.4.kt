package com.example.kotlininaction.chapter2

import java.util.*

//2.4.2
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun fizzBuzz(){
    for (i in 0..100){
        print(fizzBuzz(i))
    }

    for(i in 100 downTo 1 step 2){
        println(fizzBuzz(i))
    }
}
// kotlin의 범위는 폐구간 즉 양끝을 포함한 범위이다.
// 100 down to 1 은 역방향 수열을 만든다 그 뒤에 step 2를 붙이면 100 98 96 처럼 증감값이 2가 된다.

//2.4.3
fun mapIteration(){
    val binaryReps = TreeMap<Char,String>()

    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10","11","1001")
    for((index, element) in list.withIndex()) {
        println("$index = $element")
    }
}
// kotlin 에서 map은 key,value로 이루어진다.


fun isLetter(c: Char) =  c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
// in과 !in을 사용해 컬렉션이나 원소의 범위를 검사할 수 있다.

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "it's a digit"
    in 'a'..'z', in 'A'..'Z' -> "it's a letter!"
    else -> "I don't know"
}
// in 연산자를 사용하면 값이 범위 안에 속하는지 항상 결정할 수 있다.
package com.example.kotlininaction.chapter2

fun main(args: Array<String>) {
    println("Hello world!!")
}
//2.1.1
// kotlin 에서는 함수를 선언할때 fun 이라는 키워드를 사용한다.
// 파라미터 뒤에는 그 파라미터의 타입을 쓴다.
// 함수를 최상위 수준에 정의할 수 있다 (자바는 X)
// kotlin 에서 출력은 System.out.println 대신 println 을 사용한다.

//2.1.2
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
// kotlin 에서는 함수를 사용할 때 'fun 함수이름 (파라미터): 반환 타입' 으로 사용된다.

fun add(a: Int, b: Int) = a + b
// kotlin 에서는 함수를 간결하게 표현할 수 있다.
// 이러한 함수를 식이 본문인 함수라고 하고 앞선 함수처럼 {}에 둘러싸여 졌다면 블록이 본문인 함수라고 한다.
// 위 함수 처럼 식이 본문인 함수의 반환타입을 생략할 수 있는 이유는 타입 추론 떄문이다.

//2.1.3
val question = "가나다라"
val ansuer: Int = 42

var a = 3

// kotlin 에서는 Int 와 같은 타입을 생략하는 경우가 많다.
// val(value) 변경 불가능한 참조를 저장하는 변수이다. val로 선언된 변수는 일단 초기화 하고 나면 재대입이 불가능하다.
// var(variable) 변경 가능한 참조를 저장하는 변수이다.

//2.1.4

fun stringTemplate(args: Array<String>){
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello $name")
    println("Hello ${name}!")
}

// kotlin 에서는 변수를 문자열 앞에 사용할 때에는 $기호를 추가해야 한다.
// 만약 문자열 뒤에 바로 다른 문자가 온다면 ${}을 사용하야 한다.

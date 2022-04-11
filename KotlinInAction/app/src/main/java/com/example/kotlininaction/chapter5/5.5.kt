package com.example.kotlininaction.chapter5

import java.lang.StringBuilder

//5.5.1
fun withAlphabet() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet")
        this.toString()
    }
// with 함수는 첫 번째 인자로 받은 객체를 두 번째 인자로 받은 람다의 수신 객체로 만든다.
// 인자로 받은 람다 본문에서는 this를 사용해 그 수신 객체에 접근할 수 있다.
// append와 같이 바로 사용할 수 있다.
// with가 반환한는 값은 람다코드를 실행한 결과며 그 결과는 람다 식의 본문에 있는 마지막 식의 값이다.

//5.5.2
fun applyAlphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabet")
}.toString()

// apply는 확장 함수로 정의 돼 있다. apply의 수신 객체가 전달받은 람다의 수신 객체가 된다.

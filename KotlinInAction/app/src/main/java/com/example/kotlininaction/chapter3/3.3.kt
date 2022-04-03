package com.example.kotlininaction.chapter3

//3.3
fun String.lastChar(): Char = this.get(this.length-1)
// 확장함수를 만들려면 추가하려는 함수 이름 앞에 그 함수가 확장할 클래스의 이름을 덧붙이기만 하면 된다.
// 클래스의 이름을 수신객체 타입이라 부르며, 확장함수가 호출되는 대상이 되는 값을 수신객체라고 부른다.

//3.3.3
fun <T> Collection<T>.joinToString(
    separator: String =", ",
    prefix: String = "",
    postfix: String = ""
): String{
    val result = StringBuilder(prefix)

    for((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }
        result.append(postfix)
        return result.toString()
    }
// 이제 joinToString을 마치 클래스의 맴버인 것처럼 호출 할 수 있다.
// 확장함수는 오버라이드 할 수 없다.
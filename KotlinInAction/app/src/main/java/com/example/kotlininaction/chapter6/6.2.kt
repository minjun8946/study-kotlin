package com.example.kotlininaction.chapter6

import android.app.Notification
import java.lang.IllegalArgumentException


//6.2.1
// 코틀린은 원시 타입과 래퍼 타입을 구분하지 않으므로 항상 같은 타입을 사용한다.
// 실행 시점에 숫자 타입은 가능한 한 가장 효율적인 방식으로 표현된다.
// 대부분의 경우 코틀린의 Int 타입은 자바 int 타입으로 컴파일 된다.
// 이런 컴파일이 불가능한 경우는 컬렉션과 같은 제네릭 클래스를 사용하는 경우 뿐이다.

//6.2.2
data class Person6(val name: String, val age: Int? = null) {
    fun isOlderThen(other: Person6): Boolean? {
        if (age == null || other.age == null)
            return null
        return age>other.age
    }
}

//6.2.3
fun intType(){
    val x = 1
    println(x.toLong() in listOf(1L,2L,3L))
}
// toLong과 같이 명시적으로 변환해서 같은 타입의 값으로 만든 후 비교해야 true 값이 나온다.

//6.2.4
// Any 타입이 모든 널이 될 수 없는 타입의 조상 타입이다.
// Any 가 널이 될 수 없는 타입임에 유의하라.
// 코틀린에서 널을 포함하는 모든 값을 대입할 변수를 선언하려면 Any?를 사용해야한다.

//6.2.5
fun f(): Unit {}
//코틀린 Unit 타입은 관심을 가질만한 내용을 만환하지 않는 함수의 바노한 타입으로 Unit을 쓸 수 있다.

//6.2.6
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
// Noting 타입은 아무값도 포함하지 않는다.
// Noting은 함수의 반환 타입이나 반환타일로 쓰일 타입 파라미터로만 쓸 수 있다.


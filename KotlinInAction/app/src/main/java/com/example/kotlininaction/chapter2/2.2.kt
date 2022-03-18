package com.example.kotlininaction.chapter2

//2.2.1
class Person(
    val name: String,
    var isMarried: Boolean
)

// 기본적으로 코틀린에서 프로퍼티를 선언하는 방식은 프로퍼티와 관련 있는 접근자를 선언하는 것이다.
/* 코틀린은 값을 저장하기 위한 비공개 필드와 그 필드에 값을 저장하기 위한 세터,
 필드의 값을 읽기 위한 게터로 이뤄진 간단한 디폴트 접근자 구현을 제공한다. */

fun main(){
    val person = Person("Bob", true)
    println(person.name) // result: Bob
    println(person.isMarried) // result:  true
    person.isMarried = false
    println(person.isMarried) // result: false
}

//2.2.2
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get(){
            return height == width
        }
}
// is Square 프로퍼티에는 자체 값을 저장하는 필드가 없다. 이 프로퍼티에는 자체 구현을 제공하는 게터만 존재한다.
// 클라이언트가 프로퍼티에 접근할 때마다 게터가 프로퍼티 값을 매번 다시 계산한다.
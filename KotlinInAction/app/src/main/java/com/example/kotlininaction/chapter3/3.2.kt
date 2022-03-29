package com.example.kotlininaction.chapter3

import java.lang.StringBuilder

//3.2.1
fun join(){
    val list = listOf(1,2,3)
    joinToString(list,"","",".")
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String{
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()){
        if(index > 0) result.append(separator)
         result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
// 코틀린에는 서드파티 프로젝트를 추가하거나 직접 관련 로직을 처리할 수 있는 함수가 표준 라이브러리에 들어있다.
// 이 함수는 제네릭<T>하다. 이 함수는 어떤 타입의 값을 원소로 하는 컬렉션이든 처리할 수 있다.
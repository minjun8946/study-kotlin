package com.example.kotlininaction.chapter3

import java.lang.IllegalArgumentException

//3.4.3
val list = listOf(2,3,5,7,11)

val map = mapOf(1 to "one", 7 to "seven",53 to "fifty-three")

fun Any.to(other: Any) = Pair(this, other)
fun test(){
    1 to "one"
}
// 인자가 하나뿐인 일반 메소드나 인자가 하나뿐인 확장함수에 중위 호출을 사용할 수 있다.
// 함수를 중위 호출에 사용하게 허용할 때에는 infix 변경자를 함수 샆에 선언해야 한다.
// 이런 기능을 구조 분해 선언이라고 부른다.
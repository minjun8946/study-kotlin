package com.example.kotlininaction.chapter7

data class NameComponents(
    val name: String,
    val extension: String
)

fun splitFilename(fullName: String): NameComponents{
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name,extension)
}
//무한히 componentN을 선언할 수는 업스므로 이런 구문을 무한정 사용할 수는 없다.
// 코틀린 표준 라이브러리에서는 맨 앞의 다섯 원소에 대한 componentN을 제공한다.
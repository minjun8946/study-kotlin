package com.example.kotlininaction.chapter2

import com.example.kotlininaction.chapter2.Color.*
import java.lang.Exception
import java.lang.IllegalArgumentException

//2.3.1
enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 160, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}
// 코틀린에서 enum은 소프트 키워드라 부르는 존재다.
// enum에서도 일반적인 클래스와 마찬가지로 생성자와 프로퍼티를 선언한다.
// enum 상수 목록과 메소드 정의 사이에 ;을 꼭 넣어야 한다.

//2.3.2
fun geyMnemonic(color: Color) =
    when (color) {
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO, VIOLET -> "Add"
    }
// switch 와 달리 break를 사용하지 않아도 된다.
// when 문안에서 한 분기 안에 여러 값을 매치 패턴으로 사용할 경우에는 ,를 사용한다.

//2.3.3
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty Color")
    }
// when 식의 인자로 아무 객체나 사용할 수 있다. when 안에 인자가 없어도 사용할 수 있다.

//2.3.5
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
// Sum은 Expr의 완쪽과 오른쪽 인자에 대한 참조를 left와 right 프로퍼티로 저장한다.
// (1 + 2) + 4라는 식을 저장하면 Sum(Sum(Num(1),Num(2)), Num4))라는 구조로 객체가 생긴다.
// Expr 인터페이스에는 두가지 구현 클래스가 존재한다. 따라서 식을 평가하려명 두 경우를 고려해야 한다.
// 1. 어떤 식이 수라면 그 값일 반환한다.
//2. 어떤 식이 합계라면 좌항과 우항의 값을 계산한 다음 그 두 값을 합한 값을 반환한다.

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum){
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}
// kotlin은 is를 사용해 변수 타입을 검사한다.
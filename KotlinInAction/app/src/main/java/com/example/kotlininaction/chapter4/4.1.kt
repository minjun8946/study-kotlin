package com.example.kotlininaction.chapter4

import android.view.View
import java.io.Serializable
import java.lang.IllegalArgumentException

interface Clickable{
    fun click()
}
// 이 코드는 click이라는 추상메소드가 있는 인터페이스를 정의 한 것이다.

class Button: Clickable {
    override fun click() {
        println("I was clicked")
    }
}
// kotlin에서는 클래스 이름 뒤에 :을 붙이고 인터페이스와 클래스 이름을 적는 것으로 클래스 확장과 인터페이스 구현을 모두 처리한다.

interface Clickable2{
    fun click()
    fun showOff() = println("I'm clickable!")
}
// 이 인터페이스를 구현하는 클래스는 click에 대한 구현을 제공해야 한다.
// 반면 showOff 메소드의 경우 새로운 동작을 정의할 수 도 있고 그냥 정의를 생각해서 디폴트 구현을 사용할 수도 있다.

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if(b) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable")
}
// 위의 두 인터페이스는 모두 디폴트 구현이 들어있는 showOff 메소드가 있다.
// 클래스가 구현하는 두 상위 인터페이스에 정의된 showOff 구현을 대체할 오버라이딩 메소드를 직접 지공하지 않으면 컴파일러 오류가 발생한다.

class Button1: Clickable2,Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable2>.showOff()
        super<Focusable>.showOff()
    }
}
// 구체적으로 타입을 지정하는 분법은 super<Clickable>.showOff() 처럼 <>안에 타입을 지정한다.

open class RichButton : Clickable{
    fun disable() {}

    open fun animate() {}

    override fun click() {}
}
// 기반 클래스나 인터페이스의 멤버를 오버라이드 하는 경우 그 메소드는 기본적으로 열려있다.

open class RichButton2: Clickable{
    final override fun click() {}
}
// 오버라이드하는 메소드의 구현을 하위 클래스에서 오버라이드하지 못하게 금지하려면 오버라이드하는 메소드 앞에 final을 붙인다.

abstract class Animated{
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}
// abstract로 선언한 함수는 인스턴스화 할 수 없다.
// 추상 클래스에는 구현이 없는 추상 맴버가 있어 하위 클래스에서 그 추상 멤버를 오버라이드해야만 하는게 보통이다.
// 인터페이스 멤버에게 본문이 없으면 자동으로 추상 멤버가 되지만, 그렇더라도 따로 멤버 선언 앞에 abstract 키워드를 덧붙일 필요가 없다.

//4.1.4
class Outer{
    inner class Inner{
        fun getOuterReference(): Outer = this@Outer
    }
}
// 내부클래스로 변경해서 바깥쪽 클래스에 대한 참조를 포함하게 만들고 시다면 inner 변경자를 붙여야 한다

//4.1.5

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int =
    when (e){
        is Num -> e.value
        is Sum ->eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }
// kotlin 컴파일러는 when을 사용해 Expr 타입의 값을 검사할 때 꼭 디폴트 분기인 else 분기를 덧붙이게 강제한다.
// else 분기에서는 반환할 만한 의미있는 값이 없으므로 예외를 던진다.
// 디폴트 분기가 있으면 하위클래스를 추가하더라도 컴하일러가 when이 모든 경우를 처리하는지 제대로 검사할 수 없다.

sealed class Expr1 {
    class Num(val value: Int): Expr1()
    class Sum(val left: Expr1, val right: Expr1): Expr1()
}

fun eval1(e: Expr1) : Int =
    when(e){
        is Expr1.Num -> e.value
        is Expr1.Sum -> eval1(e.right) + eval1(e.left)
    }
// 위에 만들어진 문제를 해결하기 위해 나온 것이 sealed class 이다.
// sealed class는 open이다.
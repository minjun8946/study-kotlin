package com.example.kotlininaction.chapter7

import android.R.attr.x
import android.R.attr.y
import kotlin.math.round

//7.2.1
class PointEquals(val x: Int, val y: Int){
    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if(other !is PointEquals) return false
        return other.x == x && other.y == y
    }
}
// 다른 연산자 오버로딩 관례와 달리 equals는 Any에 정의된 메소드이므로 override가 붙어있다.
// 상위 함수에 operator가 붙어있기 때문에 자동으로 operator 지정이 적용된다.

//7.2.2
class Person(
    private val firstName: String, private val lastName: String
): Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other,Person::lastName,Person::firstName)
    }
}
// 필드를 직접 비교하면 코드는 조금 더 복잡해지지만 비교속도는 훨신 더 빨라진다는 사살을 기억해야한다.
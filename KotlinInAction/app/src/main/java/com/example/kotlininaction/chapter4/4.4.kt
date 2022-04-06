package com.example.kotlininaction.chapter4

import java.io.File

//4.4.1

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(p0: File, p1: File): Int {
        return p0.path.compareTo(p1.path, ignoreCase = false)
    }
}
// object 클래스에는 생성자나 부생성자를 쓸 수 없다.
// object class는 싱글턴 객체이다.

//4.4.2
private class A {

    companion object {
        fun bar() {
            println("Companion object called ")
        }
    }
}
// 클래스 안에 정의된 객체 중 하나에 companion이라는 특별한 표시를 붙이면 클래스의 동반객체로 만들 수 있다.
// 동반 객체의 멤버를 사용하는 구문은 자바의 정적 메소드 호출이나 정적 필드 사용 구문과 같아진다.
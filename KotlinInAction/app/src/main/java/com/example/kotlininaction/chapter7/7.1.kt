package com.example.kotlininaction.chapter7

//7.1.1
data class Point(val x: Int, val y: Int){
    operator fun plus(other: Point): Point{
        return Point(x+other.x , y+other.y)
    }
}
operator fun Point.plus(other: Point): Point{
    return Point(x + other.x, y +other.y)
}
// 연산자를 오버로딩하는 함수 앞에는 꼭 operator가 있어아 한다.

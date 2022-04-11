package com.example.kotlininaction.chapter5

//5.3.1
fun sequence1(){
    val list = listOf<Int>(1,2,3,4).asSequence()
    list.map { println("map($it)"); it *it }
        .filter { println("filiter($it)"); it % 2 ==0 }
        .toList()
}
//만약 toList()가 없다면 최종연산이 없고 중간 연산만 있기 때문에 값이 나오지 않을 것이다.
// map과 filter 변환이 늦춰져서 결과를 얻을 필요가 있을 때 적용된다는 뜻이다.

fun sequence2(){
    val people = people
    println(people.asSequence().map(Person::name)
        .filter { it.length < 4 }.toList()) // x

    println(people.asSequence().filter { it.name.length < 4 }
        .map(Person::name).toList()) // o
}
// map을 먼저 하면 모든 원소를 반환한다. 하지만 filter를 먼저 하면 부적절한 원소를 먼저 제외하기 때문에 그런 원소는 반환하지 않는다.

//5.3.2
fun sequence3(){
    val naturalNumbers = generateSequence(1) {it + 1}
    val numbersTo100 = naturalNumbers.takeWhile { it<=100 }
    println(numbersTo100.sum())
}
// 이 예제에서 두 변수는 모두 시퀀스이기 때문에 지연계산을 한다. 최종 연산을 수행하기 전까지는 시퀀스의 각 숫자는 계산되지 않는다.




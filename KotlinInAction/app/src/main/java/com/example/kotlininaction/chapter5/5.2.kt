package com.example.kotlininaction.chapter5

val people = listOf(Person("Alice",29), Person("Bob", 31))

fun filter(){
    val list = listOf(1,2,3,4)
    println(list.filter { it > 2 })
    println(list.map { it * 2 })
}
// filter 함수는 컬렉션을 이터레이션 하면서 주어진 람다에 각 원소를 넘겨 람다가 true인 원소만 모은다.
// map 함수는 주어진 람다를 컬렉션의 각 원소에 적용한 결과를 모아서 새 컬렉션을 만든다.

fun filterMap(){
    println(people.filter { it.age >30 }.map { Person::name })
}
// 멤버 참조를 사용해 더 간결한 코드를 짤 수 있다.

fun filterMax(){
    people.filter { it.age == people.maxByOrNull(Person::age)!!.age }
    val maxAge = people.maxByOrNull(Person::age)!!.age
    people.filter { it.age == maxAge }
}
// 람다를 인자로 받는 함수를 람다에 넘기면 겉으로 볼 때는 단순해 보이는 식이 내부 로직의 복잡도로 인해 실제로는 엄청나게 불합리한 계산식이 될 때가 있다.

fun groupBy(){
    println(people.groupBy { it::age })
    val list = listOf("asdf","zxcv")
    println(list.groupBy(String::first))
}
// groupBy의 결과 타입은 Map<T,List<Y>>이다.

//5.2.4
fun flatMap(){
    val strings=  listOf("abc","def")
    println(strings.flatMap { it.toList() })
}

fun sequence(){
    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()
}
// sequence를 사용하면 중간 임시 컬렉션을 사용하지 않고도 컬렉션 연산을 연쇄할 수 있다.
//원본 리스트에 원소가 2개밖에 없다면 리스트가 2개 더 생겨도 큰 문제가 되지 않겠지만 원소가 수백만 개가 되면 훨씬 더 효율이 떨어진다.
//각 연산이 컬렉션을 직접 사용하는 대신 시퀀스를 사용하게 만드는게 중요하다.
//sequence는 interface위에 구현된 연산이 계산을 수행하는 방법 때문에 생긴다.
// 따라서 중간 처리 결과를 저장하지 않아도 연산을 연쇄적으로 적용해서 효율적으로 계산을 수행할 수 있다.
// 큰 컬렉션에 대해서는 sequence를 사용하고 리스트로 바꾸는 것이 좋다.


package com.example.kotlininaction.chapter5

import com.example.kotlininaction.chapter3.joinToString
import com.example.kotlininaction.chapter3.list
import com.example.kotlininaction.chapter4.Button

data class Person(val name : String, val age: Int)

fun lambda(){
    val people = listOf(Person("Allce",29),Person("Bob",31))
    println(people.maxByOrNull{person ->  person.age})
}
//이 코드처럼 람다가 어떤 함수의 유일한 인자이고 괄호 뒤에 람다를 썼다면 호출 시 빈 괄호를 없애도 된다.

fun lambda2(){
    val people = listOf(Person("가나다",29),Person("rkskek",31))
    val names = people.joinToString("", transform = {p -> p.name })
    println(names)
    people.joinToString(" ") { it.name }
    val getAge = {people: Person -> people.age}
}
//람다는 괄호 밖에서 사용할 수도 있다.
// 람다의 디폴트 이름은 it이다.
// 람다를 변수에 지정할 떄는 파라미터의 타입을 추론할 문맥이 존재하지 않는다. 따라서 파라미터 타입을 명시해야 한다.
// 본문이 여러 줄로 이뤄진 경우 본문의 맨 마지막에 있는 식이 람다의 결과 값이 된다.

//5.1.4
fun printMessageWithPrefix(message: Collection<String>,prefix: String){
    message.forEach { println("$prefix $it") }
}
//람다 안에서 무명 내부클래스를 정의 할 때 메소드의 로컬 변수를 무명 내부 클래스에서 사용할 수 있다.

fun printProblemCounts(response: Collection<String>) {
    var clientError = 0
    var serverError = 0
    response.forEach {
        if(it.startsWith("4")) {
            clientError++
        }else if (it.startsWith("5")) serverError++
    }
    println("$clientError clint errors, $serverError server errors")
}
// prefix,clientErrors, serverError와 같이 람다 안에서 사용하는 외부 변수를 람다가 포획한 변수라고 부른다.

//5.1.5
val getAge = Person::age
val a = ::getAge
// Person::age는 같은 역할을 하는 다음 람다 식을 더 간략하게 표현한 것이다.
// ::를 사용하는 식을 멤버 참조라고 부른다. 멤버 참조는 프로퍼티나 메스드를 단 하나만 호출하는 함수 값을 만들어준다.


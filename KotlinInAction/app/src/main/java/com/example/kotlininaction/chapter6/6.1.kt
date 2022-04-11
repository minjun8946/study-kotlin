package com.example.kotlininaction.chapter6

//6.1.1
fun strLenSafe(s: String?) {}
// 이 함수가 널과 문자열을 인자로 받을 수 있게 하려면 타입 이름 뒤에 ?을 명시해야 한다.
// 어떤 타입이든 타입 이름 뒤에 물음표를 붙이면 그 타입의 변수나 프로퍼티에 null 참조를 저장할 수 있다는 뜻이다.
// 널이 될 수 있는 타입인 변수가 있다면 그에 대해 수행할 수 있는 연산이 제한된다.

//6.1.3
class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name
// ?.연산자를 사용하면 다른 추가 검사 없이 프포퍼티를 단 한 줄로 가져올 수 있다.

//6.1.4
fun elvisStrLenSafe(s: String?): Int = s?.length ?: 0
//kotlin에서는 return이나 throw등의 연산도 식이다. 따라서 엘비스 연산자의 우항에 return throw 드의 연산을 넣을 수 있다.

//6.1.5
class Person(val firstName: String, val lastName: String){
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false
        return otherPerson.firstName == this.firstName &&
                otherPerson.lastName == this.lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}
// 이 패턴을 사용하면 파라미터로 받은 값이 원하는 타입인지 쉽게 검사하고 캐스트 할 수 있고 원하는 타입이 아닐경우 false를 반환한다.
// 일단 타입을 검사한 후 null 값을 거부하고 나면 컴파일러가 otherPerson이라는 사실을 알고 적절히 처리해줄 수 있다.

//6.1.6
fun ignoreNulls(s: String?){
    val sNotNull: String = s!!
    println(sNotNull.length)
}
//만약 s에 null이 들어간다면 NullPointerException를 던지는 일 외에 코틀린이 택할 수 있는 대안이 별로 없다.
// !!는 컴파일러에게 이 값이 null이 아니고 에외가 발생해도 감수하겠다라고 말하는 것이다.
// 여러 !! 단언물을 한 줄에 함께 쓰는 일을 피하라

//6.1.7
fun sendEmailTo(email: String){
    println("sending email to $email")
}

fun let(){
    val email: String?= null
    email?.let { sendEmailTo(it) }
}
// let 함수를 사용하게 되면 자동으로 null을 반환하게 되어 위의 람다 식은 결코 실행 되지 않는다.

//6.1.9
fun verifyUserInput(input: String?){
    if(input.isNullOrBlank())
        println("Please Fill in the required fields")
}
// 널이 될 수 있는 수신 객체 타입에 대해 선언된 확장 함수를 호출 가능하다.

fun <T>printHashCode(t: T){
    println(t?.hashCode())
}
// 타입 파라미터의 타입 이름 T에는 ?가 없지만 t는 null을 받을 수 있다.

fun <T: Any>printHashCode1(t:T){
    println(t.hashCode())
}
//타입 파라미터가 널이 아님을 확실히 하려면 널이 될 수 없는 타입 상한을 지정헤야 한다.
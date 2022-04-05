package com.example.kotlininaction.chapter4

//4.3.1
class Client(val name: String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client) return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = 31 * name.hashCode() + postalCode

}
fun processed(){
    val processed = hashSetOf(Client("가나다",1234))
    println(processed.contains(Client("가나다", 1234)))
    val a = Client2("a",1)

}
// 만약 hashcode가 없다면 contains에서는 false가 나온다.
// hashSet은 원소를 비교할 때 비용을 줄이기 위해 먼저 객체의 해시 코드를 비교하고 같은 경우에만 값을 비교한다.

//4.3.2
data class Client2(val name: String, val postalCode: Int)
//data class를 사용한다면 equals, hashCode, copy, toString을 구현해준다.

//4.3.3
class DelegatingCollection<T>(
    private val innerList: MutableCollection<T>
): Collection<T> by innerList {
    override val size: Int
        get() = innerList.size
}
// by 키워드를 통해 그 인터페이스에 대한 구현을 다른 객체에 위임 중이라는 사실을 명시할 수 있다.


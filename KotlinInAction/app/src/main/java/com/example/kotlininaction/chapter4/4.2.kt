package com.example.kotlininaction.chapter4

import android.content.Context
import android.util.AttributeSet
import android.view.View

//4.2.1
class User constructor(_nickname: String){
    val nickname : String

    init {
        this.nickname = _nickname
    }
}
// 이 예제에서 constructor 키워드는 주 생성자나 부 생성자를 정의를 시작할 때 사용한다.
// init 키워드는 초기화 블록을 시작한다. 초기화 블록을 시작한다.

interface User1 {val nickname: String}

class PrivateUser(override val nickname: String): User1

class SubscribingUser(val email: String) : User1{
    override val nickname: String
        get() = email
}
// super 키워드를 사용해 상위 클래스 생성자를 호출한다.

//4.2.4

fun main1(){
    val a = User2("minjun")
    a.address = "138"
}
class User2(val name: String){
    var address: String = "unspecified"
        set(value) {
            println("Adrrress was changed for $field: $value")
            field = value
        }
}
// get,set과 같은 접근자의 본분에서는 field라는 특별한 식별자를 통해 뒷받침하는 필드에 접근할 수 있다.

class LengthCounter{
    var counter: Int = 0
        private set

    fun addWord(word:String){
        counter+=word.length
    }
}

fun lengthCounter() {
    val lengthCounter = LengthCounter()

    lengthCounter.addWord("Hi!")
}
// private set을 하게 되면 클래스 밖에서 수정을 할 수 없게 된다.



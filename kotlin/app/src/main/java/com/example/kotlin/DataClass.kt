package com.example.kotlin

fun main(){
    val a = SampleClass(1)
    val b = a.copy()
    val c = a
    a.num =3
    println(a.num)
    println(b.num)
    println(c.num) // shallow copy

    val mutableA = SampleClass2(mutableListOf("aa","aaa"))
    val mutableB = mutableA.copy()
    val mutableC = mutableA.deepCopy()
    mutableA.array.add("add")
    println(mutableA.array)
    println(mutableB.array)
    println(mutableC.array)

    val component = SampleClass3(1,"aaa")
    val (num) = component
    println(num)
    println(component.component2())

}

data class SampleClass(var num: Int){
}

data class SampleClass2(var array: MutableList<String>){
    fun deepCopy(): SampleClass2 {
        return SampleClass2(array.toMutableList())
    }
}

data class SampleClass3(val num: Int, val str: String)
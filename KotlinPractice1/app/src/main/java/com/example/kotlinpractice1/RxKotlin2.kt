package com.example.kotlinpractice1

import android.annotation.SuppressLint
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

@SuppressLint("CheckResult")
fun main(args : Array<String>){
    Flowable.range(1,15)
        .map { MyItem6(it) }
        .observeOn(Schedulers.io())
        .subscribe(object : Subscriber<MyItem6> {
            lateinit var subscription: Subscription
            override fun onSubscribe(subscription: Subscription?) {
                this.subscription = subscription!!
                subscription.request(1)
            }


            override fun onNext(t: MyItem6?) {
                runBlocking { delay(50) }
                println("Subscriber received $t")
            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onComplete() {
                println("DONE")
            }
        })
    runBlocking { 10000 }
}

data class MyItem6(val id : Int){
    init {
        println("MyItem Created $id")
    }
}
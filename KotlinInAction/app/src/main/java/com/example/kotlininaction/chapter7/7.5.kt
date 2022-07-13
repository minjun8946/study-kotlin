package com.example.kotlininaction.chapter7

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

fun main(){

    val observable = Observable.interval(1,TimeUnit.SECONDS)
        .observeOn(Schedulers.newThread())
        .subscribe{
            println(it)
        }
    val observable2 = Observable.interval(1,TimeUnit.SECONDS)
        .observeOn(Schedulers.newThread())
        .subscribe(::println)

    val compositeDisposable = CompositeDisposable()
    compositeDisposable.add(observable)
    compositeDisposable.add(observable2)
    compositeDisposable.dispose()

    println(observable.isDisposed)
    println(observable2.isDisposed)


}
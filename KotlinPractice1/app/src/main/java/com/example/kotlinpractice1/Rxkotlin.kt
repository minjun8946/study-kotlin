package com.example.kotlinpractice1


import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main() = runBlocking {


    val flowable = Flowable.range(1, 150)
    flowable
        .map {
            println("Mapping item $it")
            it
        }
        .observeOn(Schedulers.computation())
        .subscribe(MySubscriber())
    delay(10000)
}
class MySubscriber : Subscriber<Int>{
    override fun onSubscribe(s: Subscription?) {
        s?.request(Long.MAX_VALUE)
    }

    override fun onComplete() = println("onComplete()")
    override fun onError(t: Throwable?) = t!!.printStackTrace()
    override fun onNext(t: Int?) {
        runBlocking { delay(10) }
        println("onNext(): $t - ${Thread.currentThread().name}")
    }
}




/* val observable = Observable.range(1,10)
    observable
        .map {
            val str = "Mapping item $it"
            runBlocking { delay(100) }
            println("$str - ${Thread.currentThread().name}")
            str
        }
        .observeOn(Schedulers.computation())
        .subscribe {
            println("Received $it - ${Thread.currentThread().name}")
            runBlocking { delay(200) }
        }
    delay(1000)*/





/*  val observable = Observable.interval(100,TimeUnit.MILLISECONDS)
  val subject =PublishSubject.create<Long>()
  observable.subscribe(subject)
  runBlocking { delay(300) }
  subject.subscribe{println("1st: $it")}
  runBlocking { delay(300) }
  subject.subscribe{println("2st: $it")}
  runBlocking { delay(300) }*/








/*val connectableObservable = (1..10).toObservable().publish()

connectableObservable.subscribe{println("firsh subcriber: $it")}
println("Add first subscriber")
connectableObservable.map{"second subscriber: $it"}
        .subscribe(){println(it)}
println("Add second subscriber")

connectableObservable.connect()

connectableObservable.subscribe{println("Subscription 3 $it")}*/









/*val observable = Observable.interval(100,TimeUnit.MILLISECONDS)
val observer = object : Observer<Long>{
    lateinit var disposable: Disposable

    override fun onComplete() =println("onComplete()")
    override fun onNext(t: Long) {
        println("onNext() - $t")
        if (t>=5 && !disposable.isDisposed){
            disposable.dispose()
        }
    }
    override fun onError(e: Throwable) =println("onError() - ${e.message}")

    override fun onSubscribe(d: Disposable) {
        println("onSubscribe() - $d")
        disposable = d
    }
}
observable.subscribe(observer)*/










/*val obserable = Observable.range(1,3)

obserable.subscribe(
        {it->println("onNext - $it")},
        {err ->println("onError - $err")},
        {println("onComplele()")}
)*/






/*val list = listOf(1,2,3)
val num =3
val str = "wow!"
val map = mapOf(1 to "one",2 to "two")

val justOb = Observable.just(list,num,str,map)

val c : Observer<Any> = object : Observer<Any>{
    override fun onComplete() = println("onComplete")
    override fun onError(e: Throwable) = println("${e.message}")
    override fun onNext(t: Any) = println("$t")
    override fun onSubscribe(d: Disposable) =println("onSubscribe() - $d")
}
justOb.subscribe(c)*/



/*val a = Observable.create<Int>{ // create로 만들기
    it.onNext(1)
    it.onNext(2)
    it.onComplete()
}
val b = Observable.create<Int> {
    it.onNext(1)
    it.onNext(2)
    it.onError(Exception("Wow!! excptiopn"))
}
val c : Observer<Int> = object : Observer<Int>{
    override fun onComplete() = println("onComplete")
    override fun onError(e: Throwable) = println("${e.message}")
    override fun onNext(t: Int) = println("$t")
    override fun onSubscribe(d: Disposable) =println("onSubscribe() - $d")
}
a.subscribe(c)
b.subscribe(c)*/




/*val observer: Observer<String> = object : Observer<String>{
    override fun onComplete() { //가지고 있는 값을 모두 전달하면 호출함
        println("onComplete()")
    }

    override fun onNext(t: String) { //값을 전달할때 호출하여 값을 넘겨줌
        println("onNest() - $t")
    }

    override fun onError(e: Throwable) { // 에러가 발생하면 호출함
        println("onError() - ${e.message}")
    }

    override fun onSubscribe(d: Disposable) { // 구독을 신청하면 호출하줌
        println("onSubscribe() - $d")
    }
}*/

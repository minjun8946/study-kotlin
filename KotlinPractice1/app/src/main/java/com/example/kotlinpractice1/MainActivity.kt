package com.example.kotlinpractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val put : EditText = findViewById(R.id.put)
        val text : TextView = findViewById(R.id.text)

        val editTextChangeObserver = put.textChanges()

        /*val searchEditTextSubscription : @NonNull io.reactivex.rxjava3.core.Observable<CharSequence>? =
            editTextChangeObserver.debounce(800,TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribeOn(

                )*/

        var putString =""
        val observable1 :io.reactivex.Observer<String> = object : Observer<String>{
            override fun onComplete() { // 값이 완전히 전달이 되면 호출
                println("모든 값이 전달이 되었습니다!")
            }

            override fun onError(e: Throwable) { // 에러가 나면 호출

            }

            override fun onNext(t: String) { // 값이 하난 전달 될때마다 호출
                println("값이 전달 되었습니다 $t")
                text.text = t
            }

            override fun onSubscribe(d: Disposable) { // 구독을 할 때 호출

            }


        }


        put.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("입력하기 전입니다. ${put.text}")
            }

            override fun afterTextChanged(s: Editable?) {
                println("입력이 완료도었습니다 ${put.text}")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                println("입력 중입니다, ${put.text}")
                putString =put.toString()
                val observable = Observable.create<String>{
                    it.onNext(put.text.toString())

                }

                observable.subscribe(observable1)

            }
        })











    }
}


package com.example.kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {


    private val _stateFlow = MutableStateFlow<Int>(0)
    val stateFlow: StateFlow<Int> = _stateFlow

    fun a() {
        viewModelScope.launch {
            for (i in 0..10) {
                _stateFlow.value = 1
            }
        }
    }

    init {
        higherFun { b() }
    }

    private fun b(): String {
        println("1111")
        return "aaa"
    }

    private fun higherFun(func: () -> String) {
        func.invoke()
    }

}
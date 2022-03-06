package com.example.kotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {


    val _stateFlow = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = _stateFlow

    fun a(){
        viewModelScope.launch {
            for(i in 0..10){
                delay(100)
                _stateFlow.value = i
            }
        }
    }

}
package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding, R : ViewModel> : AppCompatActivity() {
    lateinit var binding: T

    abstract val layoutId : Int
    abstract val viewModel: R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this@BaseActivity
        binding.setVariable(BR.vm,viewModel)
        init()
    }
    abstract fun init()
}
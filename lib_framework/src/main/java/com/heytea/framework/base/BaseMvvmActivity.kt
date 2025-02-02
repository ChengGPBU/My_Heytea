package com.heytea.framework.base

import android.os.Bundle
import android.os.Parcel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseMvvmActivity<DB : ViewBinding, VM : ViewModel>() : BaseDataBindActivity<DB>(){

    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel()
        super.onCreate(savedInstanceState)
    }

    private fun initViewModel() {
        val argument = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
        mViewModel = ViewModelProvider(this).get(argument[1] as Class<VM>)
    }
}
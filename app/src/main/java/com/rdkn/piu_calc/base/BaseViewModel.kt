package com.rdkn.piu_calc.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val mDisposables = CompositeDisposable()

    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }

    fun addDisposable(disposable: Disposable) {
        mDisposables.add(disposable)
    }
}
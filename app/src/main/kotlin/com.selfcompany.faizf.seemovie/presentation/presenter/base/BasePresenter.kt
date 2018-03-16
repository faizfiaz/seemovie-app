package com.selfcompany.faizf.newbase.base

import android.app.Activity
import dagger.Module
import javax.inject.Inject

@Module
abstract class BasePresenter<T>{
    @Inject protected lateinit var activity: Activity
    protected val TAG = this.javaClass.toString()

    protected var mView: T? = null

    val isViewAttached: Boolean
        get() = mView != null

    fun attachView(view: T) {
        this.mView = view
    }

    fun detachView() {
        if (mView != null) {
            mView = null
        }
    }

//    protected abstract fun create(saveState: Bundle)
//
//    protected abstract fun resume()
//
//    protected abstract fun pause()
//
//    protected abstract fun destroy()
//
//    protected abstract fun saveState(outState: Bundle)
}


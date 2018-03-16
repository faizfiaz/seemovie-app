package com.selfcompany.faizf.seemovie.presentation.presenter.pres

import android.os.Bundle
import com.selfcompany.faizf.newbase.manager.IntentManager
import javax.inject.Inject

/**
 * Created by faizf on 08/03/2018.
 */
abstract class BasePresenter<T>{

    protected val TAG = this.javaClass.toString()

    @Inject lateinit var intentManager: IntentManager


    protected var mView: T? = null


    fun attachView(view: T) {
        this.mView = view
    }

    fun detachView() {
        if (mView != null) {
            mView = null
        }
    }

    fun isViewAttached(): Boolean {
        return mView != null
    }

    protected abstract fun create(saveState: Bundle)

    protected abstract fun resume()

    protected abstract fun pause()

    protected abstract fun destroy()

    protected abstract fun saveState(outState: Bundle)
}
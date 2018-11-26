package com.selfcompany.faizf.seemovie.implementor.presenter.observer

import com.selfcompany.faizf.newbase.callback.CallbackConnection
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DefaultObserver

/**
 * Created by faizf on 08/03/2018.
 */
class GenericObserver<T> constructor(private val callbackConnection: CallbackConnection): DefaultObserver<T>(), Disposable {

    override fun isDisposed(): Boolean {
       return false
    }

    override fun dispose() {

    }

    override fun onNext(value: T) {
        callbackConnection.onSuccess(value)
    }

    override fun onError(e: Throwable?) {

    }

    override fun onComplete() {

    }
}
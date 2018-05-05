package com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.selfcompany.faizf.newbase.callback.CallbackConnection
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.domain.interactor.GetPopular
import com.selfcompany.faizf.seemovie.domain.interactor.GetTopRated
import com.selfcompany.faizf.seemovie.domain.interactor.GetUpcoming
import com.selfcompany.faizf.seemovie.presentation.presenter.observer.GenericObserver
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.BasePresenter
import com.selfcompany.faizf.seemovie.presentation.view.activity.DetailMovieActivity
import com.selfcompany.faizf.seemovie.presentation.view.activity.SeeMoreActivity
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class SeeMorePres @Inject constructor(private val context: Context) :BasePresenter<SeeMoreActivity>(), CallbackConnection {

    @Inject internal lateinit var getTopRated: GetTopRated
    @Inject internal lateinit var getPopular: GetPopular
    @Inject internal lateinit var getUpcoming: GetUpcoming

    init {
        (context as SeeMovieApp).injector.inject(this)
    }


    override fun create(saveState: Bundle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveState(outState: Bundle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var bundle: Bundle

    fun getData(stringExtra: String?, i: Int) {
        if (i == 1) {
            mView?.createLoading()
        }
        bundle = Bundle()
        bundle.putBoolean("condition", true)
        bundle.putInt("page", i)
        when(stringExtra){
            "top" -> getTopRated.execute(GenericObserver(this), bundle)
            "popular" -> getPopular.execute(GenericObserver(this), bundle)
            "upcoming" -> getUpcoming.execute(GenericObserver(this), bundle)
        }
    }

    override fun onSuccess(o: Any?) {
        mView?.dismissLoading()
        mView?.setList(o)
    }

    override fun onSuccessNull() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun goDetail(any: Any) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra("id", any.toString())
        context.startActivity(intent)
    }

}
package com.selfcompany.faizf.seemovie.presentation.presenter.pres.fragment

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.selfcompany.faizf.newbase.callback.CallbackConnection
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.domain.interactor.GetNowPLaying
import com.selfcompany.faizf.seemovie.domain.interactor.GetPopular
import com.selfcompany.faizf.seemovie.domain.interactor.GetTopRated
import com.selfcompany.faizf.seemovie.domain.interactor.GetUpcoming
import com.selfcompany.faizf.seemovie.domain.model.NowPlayingItem
import com.selfcompany.faizf.seemovie.domain.model.PopularItem
import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.domain.model.UpcomingItem
import com.selfcompany.faizf.seemovie.presentation.presenter.observer.GenericObserver
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.BasePresenter
import com.selfcompany.faizf.seemovie.presentation.view.activity.DetailMovieActivity
import com.selfcompany.faizf.seemovie.presentation.view.activity.SeeMoreActivity
import com.selfcompany.faizf.seemovie.presentation.view.fragment.MovieFragment
import javax.inject.Inject

/**
 * Created by faizf on 08/03/2018.
 */
class MoviePres @Inject constructor(private val context: Context) : BasePresenter<MovieFragment>(), CallbackConnection {

    @Inject internal lateinit var getNowPlaying: GetNowPLaying
    @Inject internal lateinit var getTopRated: GetTopRated
    @Inject internal lateinit var getPopular: GetPopular
    @Inject internal lateinit var getUpcoming: GetUpcoming

    init {
        (context as SeeMovieApp).injector.inject(this)
    }

    fun getData() {
        mView?.createLoading()
        fetchData()
    }

    lateinit var bundle: Bundle

    fun fetchData(){
        bundle = Bundle()
        bundle.putBoolean("condition", true)
        bundle.putInt("page", 1)
        getNowPlaying.execute(GenericObserver(this), bundle)
        getTopRated.execute(GenericObserver(this), bundle)
        getPopular.execute(GenericObserver(this),bundle)
        getUpcoming.execute(GenericObserver(this), bundle)
    }

    fun disposeAll(){
        getNowPlaying.dispose()
        getTopRated.dispose()
        getPopular.dispose()
        getUpcoming.dispose()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onSuccess(o: Any?) {
        mView?.dismissLoading()
        if (o is MutableList<*>) {
            if (o[0] is NowPlayingItem) run {
                val data = o as MutableList<NowPlayingItem>
                mView?.createSlider(data)
                return
            }
            if (o[0] is TopRatedItem) run {
                val data = o as MutableList<TopRatedItem>
                mView?.createListTopRated(data)
                return
            }
            if (o[0] is PopularItem) run {
                val data = o as MutableList<PopularItem>
                mView?.createListPopular(data)
                return
            }
            if (o[0] is UpcomingItem) run {
                val data = o as MutableList<UpcomingItem>
                mView?.createListUpcoming(data)
                return
            }
        }
    }

    override fun onSuccessNull() {

    }


    override fun create(saveState: Bundle) {

    }

    override fun resume() {
       fetchData()
    }

    override fun pause() {
       disposeAll()
    }

    override fun destroy() {
        disposeAll()
    }

    override fun saveState(outState: Bundle) {

    }

    fun goToDetail(any: Any) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra("id", any.toString())
        context.startActivity(intent)
    }

    fun goMore(s: String) {
        val intent = Intent(context, SeeMoreActivity::class.java)
        intent.putExtra("from", s)
        context.startActivity(intent)
    }
}
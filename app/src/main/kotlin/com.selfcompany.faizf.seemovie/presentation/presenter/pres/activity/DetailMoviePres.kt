package com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.selfcompany.faizf.newbase.callback.CallbackConnection
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.data.entity.movie.DetailMovieEntity
import com.selfcompany.faizf.seemovie.data.entity.movie.RecommendationMovieEntity
import com.selfcompany.faizf.seemovie.data.entity.movie.VideoMovieEntity
import com.selfcompany.faizf.seemovie.domain.interactor.DetailMovie
import com.selfcompany.faizf.seemovie.domain.interactor.RecommendationMovie
import com.selfcompany.faizf.seemovie.domain.interactor.VideoMovie
import com.selfcompany.faizf.seemovie.presentation.presenter.observer.GenericObserver
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.BasePresenter
import com.selfcompany.faizf.seemovie.presentation.view.activity.DetailMovieActivity
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class DetailMoviePres @Inject constructor(private val context: Context) : BasePresenter<DetailMovieActivity>(), CallbackConnection {

    @Inject internal lateinit var detailMovie: DetailMovie
    @Inject internal lateinit var videoMovie: VideoMovie
    @Inject internal lateinit var recommendationMovie: RecommendationMovie

    init {
        (context as SeeMovieApp).injector.inject(this)
    }

    override fun create(saveState: Bundle) {

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {

    }

    override fun saveState(outState: Bundle) {

    }

    fun getData(id: String) {
        mView?.createLoading()
        detailMovie.execute(GenericObserver(this), id)
        videoMovie.execute(GenericObserver(this), id)
        recommendationMovie.execute(GenericObserver(this), id)

    }

    override fun onSuccess(o: Any?) {
        mView?.dismissLoading()
        if(o is DetailMovieEntity){
            mView?.setData(o)
            return
        }
        if (o is VideoMovieEntity){
            mView?.setVideo(o)
            return
        }
        if (o is RecommendationMovieEntity){
            mView?.setRecommendation(o.results)
            return
        }
    }

    override fun onSuccessNull() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toDetail(any: Any) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra("id", any.toString())
        context.startActivity(intent)
    }
}
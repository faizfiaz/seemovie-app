package com.selfcompany.faizf.seemovie.presentation.detailmovie

/**
 * Created by faizf on 16/03/2018.
 */

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerFullScreenListener
import com.selfcompany.faizf.newbase.entity.movie.MovieEntity
import com.selfcompany.faizf.seemovie.R
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.data.entity.movie.DetailMovieEntity
import com.selfcompany.faizf.seemovie.data.entity.movie.VideoMovieEntity
import com.selfcompany.faizf.seemovie.implementor.presenter.callback.CallbackItemClicked
import com.selfcompany.faizf.seemovie.implementor.presenter.callback.CallbackTrailer
import com.selfcompany.faizf.seemovie.presentation.activity.BaseActivity
import com.selfcompany.faizf.seemovie.presentation.adapter.AdapterRecommendation
import com.selfcompany.faizf.seemovie.presentation.adapter.AdapterTrailer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_movie.*
import javax.inject.Inject


class DetailMovieActivity : BaseActivity(), CallbackItemClicked, CallbackTrailer {

    @Inject lateinit var presenter : DetailMoviePres

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        (application as SeeMovieApp).injector.inject(this)

        presenter.attachView(this)

        presenter.getData(intent.getStringExtra("id"))

    }

    fun backActivity(view: View){
        onBackPressed()
    }

    @SuppressLint("SetTextI18n")
    fun setData(o: DetailMovieEntity) {
        Picasso.with(this).load("https://image.tmdb.org/t/p/w1280" + o.backdrop_path).into(image)
        status.text = o.status
        titles.text = o.original_title
        var genres = ""
        o.genres.forEach {  genres += " | " + it.name }
        genre.text = genres
        playtime.text = o.runtime.toString() + "Minutes"
        year.text = o.release_date.substring(0, 4)
        overview.text = o.overview
    }

    fun setVideo(o: VideoMovieEntity) {

        trailers?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = applicationContext?.let { AdapterTrailer(o.results, it, this) }
        trailers?.adapter = adapter
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(trailers)

        setPlayerVideo(o.results[0].key)
    }

    fun setPlayerVideo(key: String){
        player.initialize({ initializedYouTubePlayer ->
            initializedYouTubePlayer.addListener(object : AbstractYouTubePlayerListener() {
                override fun onReady() {
                    initializedYouTubePlayer.cueVideo(key, 0f)
                }
            })
        }, true)

        player.addFullScreenListener(object : YouTubePlayerFullScreenListener {
            override fun onYouTubePlayerEnterFullScreen() {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }

            override fun onYouTubePlayerExitFullScreen() {
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            player.enterFullScreen()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            player.exitFullScreen()
        }
    }

    fun setRecommendation(results: List<MovieEntity>) {
        list?.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = applicationContext?.let { AdapterRecommendation(results, it, this) }
        list?.adapter = adapter
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(list)
    }

    override fun onClicked(any: Any) {
       presenter.toDetail(any)
    }

    override fun onClicked(key: String) {
        setPlayerVideo(key)
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    override fun onStop() {
        super.onStop()
        player.release()
    }

    override fun onBackPressed() {
        if (player.isFullScreen)
            player.exitFullScreen()
        else
            super.onBackPressed()
    }

}
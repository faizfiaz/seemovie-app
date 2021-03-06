package com.selfcompany.faizf.seemovie.presentation.cinema

import android.content.Context
import android.os.Bundle
import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.implementor.presenter.pres.BasePresenter
import javax.inject.Inject

/**
 * Created by faizf on 08/03/2018.
 */
class CinemasPres @Inject constructor(private val context: Context) : BasePresenter<CinemasFragment>() {

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
}
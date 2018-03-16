package com.selfcompany.faizf.seemovie.presentation.presenter.deps.components

import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.presentation.presenter.deps.module.*
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity.DetailMoviePres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity.MainPres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.fragment.AccountPres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.fragment.CinemasPres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.fragment.MoviePres
import com.selfcompany.faizf.seemovie.presentation.view.activity.DetailMovieActivity
import com.selfcompany.faizf.seemovie.presentation.view.activity.MainActivity
import com.selfcompany.faizf.seemovie.presentation.view.fragment.AccountFragment
import com.selfcompany.faizf.seemovie.presentation.view.fragment.CinemasFragment
import com.selfcompany.faizf.seemovie.presentation.view.fragment.MovieFragment
import com.selfcompany.faizf.seemovie.presentation.view.fragment.SliderFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by faizf on 07/03/2018.
 */
@Singleton
@Component(modules = [UtilsModule::class,
                      PresenterModule::class,
                      RepositoryModule::class,
                      MapperModule::class,
                      FactoryModule::class,
                      CacheModule::class,
                      ManagerModule::class])

interface AppComponents {

    fun inject(seeMoviesApp: SeeMovieApp)
    fun inject(sliderFragment: SliderFragment)

    fun inject(mainActivity: MainActivity)
    fun inject(mainPres: MainPres)

    fun inject(detailMovieActivity: DetailMovieActivity)
    fun inject(detailMoviePres: DetailMoviePres)

    fun inject(movieFragment: MovieFragment)
    fun inject(moviePres: MoviePres)

    fun inject(cinemasFragment: CinemasFragment)
    fun inject(cinemasPres: CinemasPres)

    fun inject(accountFragment: AccountFragment)
    fun inject(accountPres: AccountPres)


}
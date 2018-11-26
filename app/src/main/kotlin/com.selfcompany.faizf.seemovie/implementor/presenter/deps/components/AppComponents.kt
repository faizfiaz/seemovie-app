package com.selfcompany.faizf.seemovie.implementor.presenter.deps.components

import com.selfcompany.faizf.seemovie.SeeMovieApp
import com.selfcompany.faizf.seemovie.implementor.presenter.deps.module.*
import com.selfcompany.faizf.seemovie.presentation.account.AccountFragment
import com.selfcompany.faizf.seemovie.presentation.account.AccountPres
import com.selfcompany.faizf.seemovie.presentation.cinema.CinemasFragment
import com.selfcompany.faizf.seemovie.presentation.cinema.CinemasPres
import com.selfcompany.faizf.seemovie.presentation.detailmovie.DetailMovieActivity
import com.selfcompany.faizf.seemovie.presentation.detailmovie.DetailMoviePres
import com.selfcompany.faizf.seemovie.presentation.fragment.slider.SliderFragment
import com.selfcompany.faizf.seemovie.presentation.maincontainer.MainActivity
import com.selfcompany.faizf.seemovie.presentation.maincontainer.MainPres
import com.selfcompany.faizf.seemovie.presentation.movie.MovieFragment
import com.selfcompany.faizf.seemovie.presentation.movie.MoviePres
import com.selfcompany.faizf.seemovie.presentation.seemore.SeeMoreActivity
import com.selfcompany.faizf.seemovie.presentation.seemore.SeeMorePres
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

    //ACTIVITY INJECTION
    fun inject(mainActivity: MainActivity)
    fun inject(mainPres: MainPres)



    fun inject(detailMovieActivity: DetailMovieActivity)
    fun inject(detailMoviePres: DetailMoviePres)

    fun inject(seeMoreActivity: SeeMoreActivity)
    fun inject(seeMorePres: SeeMorePres)


    //FRAGMENT INJECTION
    fun inject(movieFragment: MovieFragment)
    fun inject(moviePres: MoviePres)

    fun inject(cinemasFragment: CinemasFragment)
    fun inject(cinemasPres: CinemasPres)

    fun inject(accountFragment: AccountFragment)
    fun inject(accountPres: AccountPres)


}
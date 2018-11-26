package com.selfcompany.faizf.seemovie.implementor.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.seemovie.presentation.detailmovie.DetailMoviePres
import com.selfcompany.faizf.seemovie.presentation.maincontainer.MainPres
import com.selfcompany.faizf.seemovie.presentation.movie.MoviePres
import com.selfcompany.faizf.seemovie.presentation.seemore.SeeMorePres
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 07/03/2018.
 */
@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providesMainPres(context: Context): MainPres {
        return MainPres(context)
    }

    @Provides
    @Singleton
    fun providesDetailMoviePres(context: Context): DetailMoviePres {
        return DetailMoviePres(context)
    }

    @Provides
    @Singleton
    fun providesMoviePres(context: Context): MoviePres {
        return MoviePres(context)
    }

    @Provides
    @Singleton
    fun providesSeeMorePres(context: Context): SeeMorePres {
        return SeeMorePres(context)
    }
}
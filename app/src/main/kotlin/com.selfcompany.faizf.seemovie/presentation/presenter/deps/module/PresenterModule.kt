package com.selfcompany.faizf.seemovie.presentation.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity.DetailMoviePres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity.MainPres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.activity.SeeMorePres
import com.selfcompany.faizf.seemovie.presentation.presenter.pres.fragment.MoviePres
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
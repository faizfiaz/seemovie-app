package com.selfcompany.faizf.seemovie.presentation.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.seemovie.data.cache.realm.MovieListCache
import com.selfcompany.faizf.seemovie.data.repository.datasource.movielist.MovieListDataStoreFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 08/03/2018.
 */
@Module
class FactoryModule {

    @Provides
    @Singleton
    fun provideFactoryNowPlaying(movieListCache: MovieListCache, context: Context): MovieListDataStoreFactory {
        return MovieListDataStoreFactory(movieListCache, context)
    }
}
package com.selfcompany.faizf.seemovie.presentation.presenter.deps.module

import com.selfcompany.faizf.seemovie.data.cache.realm.MovieListCache
import com.selfcompany.faizf.seemovie.data.cache.realm.MovieListCacheImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 08/03/2018.
 */
@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideNowPlayingCache(): MovieListCache{
        return MovieListCacheImpl()
    }
}
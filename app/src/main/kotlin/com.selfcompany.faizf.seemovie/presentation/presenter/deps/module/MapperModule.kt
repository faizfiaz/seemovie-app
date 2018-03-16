package com.selfcompany.faizf.seemovie.presentation.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.seemovie.data.entity.mapper.NowPlayingMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 08/03/2018.
 */
@Module
class MapperModule {

    @Provides
    @Singleton
    fun providesMapperNowPlaying(context: Context): NowPlayingMapper{
        return NowPlayingMapper(context)
    }
}
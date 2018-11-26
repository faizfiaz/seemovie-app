package com.selfcompany.faizf.seemovie.implementor.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.seemovie.data.entity.mapper.NowPlayingMapper
import com.selfcompany.faizf.seemovie.data.repository.datasource.detailmovie.DetailMovieDataRepository
import com.selfcompany.faizf.seemovie.data.repository.datasource.detailmovie.RecommendationMovieDataRepository
import com.selfcompany.faizf.seemovie.data.repository.datasource.detailmovie.VideoMovieDataRepository
import com.selfcompany.faizf.seemovie.data.repository.datasource.movielist.MovieListDataRepository
import com.selfcompany.faizf.seemovie.data.repository.datasource.movielist.MovieListDataStoreFactory
import com.selfcompany.faizf.seemovie.domain.repository.DetailMovieRepository
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import com.selfcompany.faizf.seemovie.domain.repository.RecommendationMovieRepository
import com.selfcompany.faizf.seemovie.domain.repository.VideoMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 07/03/2018.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesNowPlayingRepository(dataFactory: MovieListDataStoreFactory, mapper: NowPlayingMapper): MovieListRepository {
        return MovieListDataRepository(dataFactory, mapper)
    }

    @Provides
    @Singleton
    fun providesDetailMovieRepository(context: Context): DetailMovieRepository {
        return DetailMovieDataRepository(context)
    }

    @Provides
    @Singleton
    fun provideMovieVideoRepository(context: Context): VideoMovieRepository {
        return VideoMovieDataRepository(context)
    }

    @Provides
    @Singleton
    fun provideRecommendationMovieRepository(context: Context): RecommendationMovieRepository {
        return RecommendationMovieDataRepository(context)
    }
}
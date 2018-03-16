package com.selfcompany.faizf.seemovie.data.repository.datasource.movielist

import com.selfcompany.faizf.seemovie.data.entity.mapper.NowPlayingMapper
import com.selfcompany.faizf.seemovie.domain.model.*
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 07/03/2018.
 */
class MovieListDataRepository @Inject constructor(private val dataFactory: MovieListDataStoreFactory,
                                                  private val mapper : NowPlayingMapper) : MovieListRepository{
    override fun upcoming(isRefresh: Boolean): Observable<MutableList<UpcomingItem>> {
        return dataFactory.create(isRefresh, CategoryListMovie.UPCOMING).listMovie()!!.map({ it -> mapper.transformList<UpcomingItem>(it.results, CategoryListMovie.UPCOMING) })
    }

    override fun popular(isRefresh: Boolean): Observable<MutableList<PopularItem>> {
        return dataFactory.create(isRefresh, CategoryListMovie.POPULAR).listMovie()!!.map({ it -> mapper.transformList<PopularItem>(it.results, CategoryListMovie.POPULAR) })
    }

    override fun topRated(isRefresh: Boolean): Observable<MutableList<TopRatedItem>> {
        return dataFactory.create(isRefresh, CategoryListMovie.TOP_RATED).listMovie()!!.map({ it -> mapper.transformList<TopRatedItem>(it.results, CategoryListMovie.TOP_RATED) })
    }

    override fun nowPlaying(isRefresh: Boolean): Observable<MutableList<NowPlayingItem>> {
        return dataFactory.create(isRefresh, CategoryListMovie.NOW_PLAYING).listMovie()!!.map({ it -> mapper.transformList<NowPlayingItem>(it.results, CategoryListMovie.NOW_PLAYING) })
    }



}
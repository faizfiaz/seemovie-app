package com.selfcompany.faizf.seemovie.data.repository.datasource.movielist

import com.selfcompany.faizf.newbase.entity.movie.MovieListEntity
import com.selfcompany.faizf.seemovie.data.cache.realm.MovieListCache
import com.selfcompany.faizf.seemovie.domain.model.CategoryListMovie
import io.reactivex.Observable

/**
 * Created by faizf on 07/03/2018.
 */
class MovieListLocalDataStore(private val movieListCache: MovieListCache,
                              private val category: CategoryListMovie) : MovieListDataStore {
    override fun listMovie(): Observable<MovieListEntity>? {
        return movieListCache.get(category)
    }
}
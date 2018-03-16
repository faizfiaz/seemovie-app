package com.selfcompany.faizf.seemovie.data.cache.realm

import com.selfcompany.faizf.newbase.entity.movie.MovieListEntity
import com.selfcompany.faizf.seemovie.domain.model.CategoryListMovie
import io.reactivex.Observable

/**
 * Created by faizf on 07/03/2018.
 */
interface MovieListCache {
    fun isExpired() : Boolean
    fun isCached() : Boolean
    fun get(category: CategoryListMovie) : Observable<MovieListEntity>
    fun put(item: MovieListEntity, category: CategoryListMovie)
}
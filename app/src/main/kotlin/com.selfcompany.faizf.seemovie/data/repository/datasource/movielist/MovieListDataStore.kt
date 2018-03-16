package com.selfcompany.faizf.seemovie.data.repository.datasource.movielist

import com.selfcompany.faizf.newbase.entity.movie.MovieListEntity
import io.reactivex.Observable

/**
 * Created by faizf on 07/03/2018.
 */
interface MovieListDataStore {
    fun listMovie(): Observable<MovieListEntity>?
}
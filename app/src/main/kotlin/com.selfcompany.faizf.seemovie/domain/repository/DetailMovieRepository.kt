package com.selfcompany.faizf.seemovie.domain.repository

import com.selfcompany.faizf.seemovie.data.entity.movie.DetailMovieEntity
import io.reactivex.Observable

/**
 * Created by faizf on 16/03/2018.
 */
interface DetailMovieRepository {
    fun getDetail(id: String): Observable<DetailMovieEntity>
}
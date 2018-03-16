package com.selfcompany.faizf.seemovie.domain.repository

import com.selfcompany.faizf.seemovie.data.entity.movie.VideoMovieEntity
import io.reactivex.Observable

/**
 * Created by faizf on 16/03/2018.
 */
interface VideoMovieRepository {
    fun getListVideo(id: String) : Observable<VideoMovieEntity>
}
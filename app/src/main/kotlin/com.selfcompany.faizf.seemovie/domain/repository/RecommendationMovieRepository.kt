package com.selfcompany.faizf.seemovie.domain.repository

import com.selfcompany.faizf.seemovie.data.entity.movie.RecommendationMovieEntity
import io.reactivex.Observable

/**
 * Created by faizf on 16/03/2018.
 */
interface RecommendationMovieRepository {
    fun getRecommendation(id :String) : Observable<RecommendationMovieEntity>
}
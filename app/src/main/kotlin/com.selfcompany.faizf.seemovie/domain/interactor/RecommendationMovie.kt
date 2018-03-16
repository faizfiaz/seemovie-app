package com.selfcompany.faizf.seemovie.domain.interactor

import com.selfcompany.faizf.seemovie.data.entity.movie.RecommendationMovieEntity
import com.selfcompany.faizf.seemovie.domain.repository.RecommendationMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class RecommendationMovie  @Inject constructor() : UseCase<RecommendationMovieEntity, String>() {

    @Inject
    lateinit var recommendationMovieRepository: RecommendationMovieRepository

    override fun buildUseCaseObservable(params: String): Observable<RecommendationMovieEntity> {
        return recommendationMovieRepository.getRecommendation(params)
    }
}
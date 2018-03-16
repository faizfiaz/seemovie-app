package com.selfcompany.faizf.seemovie.domain.interactor

import com.selfcompany.faizf.seemovie.data.entity.movie.DetailMovieEntity
import com.selfcompany.faizf.seemovie.domain.repository.DetailMovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class DetailMovie @Inject constructor() : UseCase<DetailMovieEntity, String>() {

    @Inject lateinit var detailMovieRepository: DetailMovieRepository

    override fun buildUseCaseObservable(params: String): Observable<DetailMovieEntity> {
        return detailMovieRepository.getDetail(params)
    }
}
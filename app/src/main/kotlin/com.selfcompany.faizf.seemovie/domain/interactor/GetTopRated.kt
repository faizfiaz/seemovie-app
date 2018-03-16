package com.selfcompany.faizf.seemovie.domain.interactor

import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 09/03/2018.
 */
class GetTopRated @Inject constructor() : UseCase<MutableList<TopRatedItem>, Boolean>() {

    @Inject
    lateinit var movieListRepository: MovieListRepository

    override fun buildUseCaseObservable(params: Boolean): Observable<MutableList<TopRatedItem>> {
        return movieListRepository.topRated(params)
    }


}
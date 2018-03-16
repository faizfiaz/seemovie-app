package com.selfcompany.faizf.seemovie.domain.interactor

import com.selfcompany.faizf.seemovie.domain.model.UpcomingItem
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 10/03/2018.
 */
class GetUpcoming @Inject constructor() : UseCase<MutableList<UpcomingItem>, Boolean>() {

    @Inject
    lateinit var movieListRepository: MovieListRepository

    override fun buildUseCaseObservable(params: Boolean): Observable<MutableList<UpcomingItem>> {
        return movieListRepository.upcoming(params)
    }
}
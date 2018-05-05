package com.selfcompany.faizf.seemovie.domain.interactor

import android.os.Bundle
import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 09/03/2018.
 */
class GetTopRated @Inject constructor() : UseCase<MutableList<TopRatedItem>, Bundle>() {
    override fun buildUseCaseObservable(params: Bundle): Observable<MutableList<TopRatedItem>> {
        return movieListRepository.topRated(params.getBoolean("condition"), params.getInt("page"))
    }

    @Inject
    lateinit var movieListRepository: MovieListRepository



}
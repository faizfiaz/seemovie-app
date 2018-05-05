package com.selfcompany.faizf.seemovie.domain.interactor

import android.os.Bundle
import com.selfcompany.faizf.seemovie.domain.model.PopularItem
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 10/03/2018.
 */
class GetPopular @Inject constructor() : UseCase<MutableList<PopularItem>, Bundle>() {
    override fun buildUseCaseObservable(params: Bundle): Observable<MutableList<PopularItem>> {
        return movieListRepository.popular(params.getBoolean("condition"), params.getInt("page"))
    }

    @Inject
    lateinit var movieListRepository: MovieListRepository

}
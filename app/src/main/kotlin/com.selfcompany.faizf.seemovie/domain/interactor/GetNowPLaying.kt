package com.selfcompany.faizf.seemovie.domain.interactor

import com.selfcompany.faizf.seemovie.domain.model.NowPlayingItem
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 07/03/2018.
 */
class GetNowPLaying @Inject constructor() : UseCase<MutableList<NowPlayingItem>, Boolean>() {

    @Inject lateinit var movieListRepository: MovieListRepository

    override fun buildUseCaseObservable(params: Boolean): Observable<MutableList<NowPlayingItem>> {
        return movieListRepository.nowPlaying(params)
    }


}
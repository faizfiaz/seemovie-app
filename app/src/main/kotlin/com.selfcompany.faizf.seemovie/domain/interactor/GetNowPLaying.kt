package com.selfcompany.faizf.seemovie.domain.interactor

import android.os.Bundle
import com.selfcompany.faizf.seemovie.domain.model.NowPlayingItem
import com.selfcompany.faizf.seemovie.domain.repository.MovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by faizf on 07/03/2018.
 */
class GetNowPLaying @Inject constructor() : UseCase<MutableList<NowPlayingItem>, Bundle>() {
    override fun buildUseCaseObservable(params: Bundle): Observable<MutableList<NowPlayingItem>> {
        return movieListRepository.nowPlaying(params.getBoolean("condition"), params.getInt("page"))
    }

    @Inject lateinit var movieListRepository: MovieListRepository



}
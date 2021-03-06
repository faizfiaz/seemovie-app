package com.selfcompany.faizf.seemovie.domain.repository

import com.selfcompany.faizf.seemovie.domain.model.NowPlayingItem
import com.selfcompany.faizf.seemovie.domain.model.PopularItem
import com.selfcompany.faizf.seemovie.domain.model.TopRatedItem
import com.selfcompany.faizf.seemovie.domain.model.UpcomingItem
import io.reactivex.Observable

/**
 * Created by faizf on 07/03/2018.
 */
interface MovieListRepository {
    fun nowPlaying(isRefresh: Boolean, int: Int) :  Observable<MutableList<NowPlayingItem>>
    fun topRated(isRefresh: Boolean, int: Int) : Observable<MutableList<TopRatedItem>>
    fun popular(isRefresh: Boolean, int: Int) : Observable<MutableList<PopularItem>>
    fun upcoming(isRefresh: Boolean, int: Int) : Observable<MutableList<UpcomingItem>>
}
package com.selfcompany.faizf.seemovie.data.repository.datasource.detailmovie

import android.content.Context
import com.selfcompany.faizf.seemovie.data.entity.movie.DetailMovieEntity
import com.selfcompany.faizf.seemovie.data.network.RestApi
import com.selfcompany.faizf.seemovie.data.network.RetrofitService
import com.selfcompany.faizf.seemovie.data.network.URL
import com.selfcompany.faizf.seemovie.domain.repository.DetailMovieRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class DetailMovieDataRepository @Inject constructor(private val context: Context): DetailMovieRepository {
    override fun getDetail(id: String): Observable<DetailMovieEntity> {
        return RetrofitService.getClient(context)?.create(RestApi::class.java)?.doGetDetailMovie(URL.detailMovie(id))
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.doOnNext({it})!!
    }
}
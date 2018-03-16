package com.selfcompany.faizf.seemovie.data.repository.datasource.detailmovie

import android.content.Context
import com.selfcompany.faizf.seemovie.data.entity.movie.RecommendationMovieEntity
import com.selfcompany.faizf.seemovie.data.network.RestApi
import com.selfcompany.faizf.seemovie.data.network.RetrofitService
import com.selfcompany.faizf.seemovie.data.network.URL
import com.selfcompany.faizf.seemovie.domain.repository.RecommendationMovieRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class RecommendationMovieDataRepository  @Inject constructor(private val context: Context): RecommendationMovieRepository {
    override fun getRecommendation(id: String): Observable<RecommendationMovieEntity> {
        return RetrofitService.getClient(context)?.create(RestApi::class.java)?.doGetRecommendationMovie(URL.recommendation(id))
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.doOnNext({it})!!
    }
}
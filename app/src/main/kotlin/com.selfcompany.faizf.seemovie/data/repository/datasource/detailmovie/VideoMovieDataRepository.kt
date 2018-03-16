package com.selfcompany.faizf.seemovie.data.repository.datasource.detailmovie

import android.content.Context
import com.selfcompany.faizf.seemovie.data.entity.movie.VideoMovieEntity
import com.selfcompany.faizf.seemovie.data.network.RestApi
import com.selfcompany.faizf.seemovie.data.network.RetrofitService
import com.selfcompany.faizf.seemovie.data.network.URL
import com.selfcompany.faizf.seemovie.domain.repository.VideoMovieRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by faizf on 16/03/2018.
 */
class VideoMovieDataRepository  @Inject constructor(private val context: Context): VideoMovieRepository {
    override fun getListVideo(id: String): Observable<VideoMovieEntity> {
        return RetrofitService.getClient(context)?.create(RestApi::class.java)?.doGetVideoMovie(URL.video(id))
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.doOnNext({ it })!!
    }
}
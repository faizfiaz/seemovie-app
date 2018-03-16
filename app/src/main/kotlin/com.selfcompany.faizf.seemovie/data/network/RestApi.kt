package com.selfcompany.faizf.seemovie.data.network

import com.selfcompany.faizf.newbase.entity.movie.MovieListEntity
import com.selfcompany.faizf.seemovie.data.entity.movie.DetailMovieEntity
import com.selfcompany.faizf.seemovie.data.entity.movie.RecommendationMovieEntity
import com.selfcompany.faizf.seemovie.data.entity.movie.VideoMovieEntity
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * Created by faizf on 07/03/2018.
 */
interface RestApi {

    @POST("login")
    fun doLogin(@Body obj: Any) : Observable<Call<Any>>

    @GET
    fun doGetListMovie(@Url url: String) : Observable<MovieListEntity>

    @GET
    fun doGetDetailMovie(@Url url: String) : Observable<DetailMovieEntity>

    @GET
    fun doGetVideoMovie(@Url url: String) : Observable<VideoMovieEntity>

    @GET
    fun doGetRecommendationMovie(@Url url: String) : Observable<RecommendationMovieEntity>
}
package com.selfcompany.faizf.seemovie.data.repository.datasource.movielist

import android.content.Context
import com.selfcompany.faizf.newbase.entity.movie.MovieListEntity
import com.selfcompany.faizf.seemovie.data.cache.realm.MovieListCache
import com.selfcompany.faizf.seemovie.data.network.RestApi
import com.selfcompany.faizf.seemovie.data.network.RetrofitService
import com.selfcompany.faizf.seemovie.data.network.URL
import com.selfcompany.faizf.seemovie.domain.model.CategoryListMovie
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by faizf on 07/03/2018.
 */
class MovieListCloudDataStore(private val movieListCache: MovieListCache,
                              private val context: Context,
                              private val category: CategoryListMovie) : MovieListDataStore {

    private lateinit var url: String

    override fun listMovie(): Observable<MovieListEntity>? {

        url = when(category){
            CategoryListMovie.NOW_PLAYING -> URL.nowPlaying
            CategoryListMovie.TOP_RATED -> URL.topRated
            CategoryListMovie.POPULAR -> URL.popular
            CategoryListMovie.UPCOMING -> URL.upcoming
        }

        return RetrofitService.getClient(context)?.create(RestApi::class.java)?.doGetListMovie(url)
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.doOnNext({ it ->  movieListCache.put(it, category)})
    }
}
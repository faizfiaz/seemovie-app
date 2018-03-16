package com.selfcompany.faizf.seemovie.data.entity.mapper

import android.content.Context
import com.selfcompany.faizf.newbase.entity.movie.MovieEntity
import com.selfcompany.faizf.seemovie.domain.model.*
import javax.inject.Inject

/**
 * Created by faizf on 07/03/2018.
 */
class NowPlayingMapper @Inject constructor(private val context: Context) {

    fun<T> transformList(listMovieEntity: List<MovieEntity>, category: CategoryListMovie) : MutableList<T>? {

        when(category){
            CategoryListMovie.NOW_PLAYING -> {
                val list : MutableList<NowPlayingItem> = arrayListOf()
                listMovieEntity.forEach { item -> transform(item)?.let { list.add(it) } }
                return list as MutableList<T>
            }
            CategoryListMovie.TOP_RATED -> {
                val list : MutableList<TopRatedItem> = arrayListOf()
                listMovieEntity.forEach { item -> transformTopRated(item)?.let { list.add(it) } }
                return list as MutableList<T>
            }
            CategoryListMovie.POPULAR -> {
                val list : MutableList<PopularItem> = arrayListOf()
                listMovieEntity.forEach { item -> transformPopular(item)?.let { list.add(it) } }
                return list as MutableList<T>
            }
            CategoryListMovie.UPCOMING -> {
                val list : MutableList<UpcomingItem> = arrayListOf()
                listMovieEntity.forEach { item -> transformUpcoming(item)?.let { list.add(it) } }
                return list as MutableList<T>
            }
        }

        return null
    }

    private fun transformUpcoming(movieEntity: MovieEntity): UpcomingItem? {
        var upcomingItem : UpcomingItem? = null
        if(movieEntity != null){
            upcomingItem = UpcomingItem(movieEntity.id, movieEntity.title, movieEntity.poster_path,movieEntity.backdrop_path, movieEntity.popularity,
                    movieEntity.genre_ids, movieEntity.overview, movieEntity.release_date, movieEntity.vote_average, movieEntity.vote_count)
        }
        return upcomingItem
    }

    private fun transformTopRated(movieEntity: MovieEntity): TopRatedItem? {
        var topRatedItem : TopRatedItem? = null
        if(movieEntity != null){
            topRatedItem = TopRatedItem(movieEntity.id, movieEntity.title, movieEntity.poster_path,movieEntity.backdrop_path, movieEntity.popularity,
                    movieEntity.genre_ids, movieEntity.overview, movieEntity.release_date, movieEntity.vote_average, movieEntity.vote_count)
        }
        return topRatedItem
    }

    private fun transformPopular(movieEntity: MovieEntity): PopularItem? {
        var popularItem : PopularItem? = null
        if(movieEntity != null){
            popularItem = PopularItem(movieEntity.id, movieEntity.title, movieEntity.poster_path)
        }
        return popularItem
    }


    private fun transform(movieEntity: MovieEntity): NowPlayingItem? {
        var nowPlayingItem : NowPlayingItem? = null
        if(movieEntity != null){
            nowPlayingItem = NowPlayingItem(movieEntity.id, movieEntity.title, movieEntity.poster_path,
                    movieEntity.backdrop_path, movieEntity.popularity, movieEntity.genre_ids, movieEntity.overview)
        }
        return nowPlayingItem
    }


}
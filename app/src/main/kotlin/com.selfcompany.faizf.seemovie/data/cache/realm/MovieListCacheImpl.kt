package com.selfcompany.faizf.seemovie.data.cache.realm

import com.google.gson.Gson
import com.selfcompany.faizf.newbase.entity.movie.MovieEntity
import com.selfcompany.faizf.newbase.entity.movie.MovieListEntity
import com.selfcompany.faizf.seemovie.data.entity.realm.MovieRealm
import com.selfcompany.faizf.seemovie.domain.model.CategoryListMovie
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.createObject
import java.text.ParseException
import java.util.*


/**
 * Created by faizf on 07/03/2018.
 */
class MovieListCacheImpl : MovieListCache {

    private val EXPIRATION_TIME = (120 * 10 * 100).toLong()

    override fun isExpired(): Boolean {
        val realm = Realm.getDefaultInstance()
        if (realm.where(MovieRealm::class.java).count() != 0L) {
            val currentTime = Date(System.currentTimeMillis())
            try {
                val isExpired = currentTime.time - realm.where(MovieRealm::class.java).findFirst()!!.lastUpdated > EXPIRATION_TIME
                if (isExpired) {
                    realm.beginTransaction()
                    realm.delete(MovieRealm::class.java)
                    realm.commitTransaction()
                    realm.close()
                }
                return isExpired
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }
        return false
    }

    override fun isCached(): Boolean {
        val realm = Realm.getDefaultInstance()
        return realm.where(MovieRealm::class.java).findAll() != null && realm.where(MovieRealm::class.java).findAll().size > 0
    }

    override fun get(category: CategoryListMovie): Observable<MovieListEntity> {
        val id: Long
        when (category) {
            CategoryListMovie.NOW_PLAYING -> {
                id = 1
            }
            CategoryListMovie.TOP_RATED -> {
                id = 2
            }
            CategoryListMovie.POPULAR -> {
                id = 3
            }
            CategoryListMovie.UPCOMING -> {
                id = 4
            }
        }

        val realm = Realm.getDefaultInstance()
        val fromDb = realm.where(MovieRealm::class.java).equalTo("id", id).findFirst()
        val data = realm.copyFromRealm(fromDb)!!

        val moviesListEntity = MovieListEntity()
        val list = Gson().fromJson(data.json, Array<MovieEntity>::class.java).toList()

        moviesListEntity.results = list
        return Observable.just<MovieListEntity>(moviesListEntity)
    }


    override fun put(item: MovieListEntity, category: CategoryListMovie) {
        val realm = Realm.getDefaultInstance()
        val json = Gson().toJson(item.results)

        when (category) {
            CategoryListMovie.NOW_PLAYING -> {
                realm.executeTransactionAsync({ realm ->
                    val movieRealm = realm.createObject<MovieRealm>(1)
                    movieRealm.json = json
                    movieRealm.lastUpdated = Date(System.currentTimeMillis()).time
                })

            }
            CategoryListMovie.TOP_RATED -> {
                realm.executeTransactionAsync({ realm ->
                    val movieRealm = realm.createObject<MovieRealm>(2)
                    movieRealm.json = json
                    movieRealm.lastUpdated = Date(System.currentTimeMillis()).time
                })
            }
            CategoryListMovie.POPULAR -> {
                realm.executeTransactionAsync({ realm ->
                    val movieRealm = realm.createObject<MovieRealm>(3)
                    movieRealm.json = json
                    movieRealm.lastUpdated = Date(System.currentTimeMillis()).time
                })
            }
            CategoryListMovie.UPCOMING -> {
                realm.executeTransactionAsync({ realm ->
                    val movieRealm = realm.createObject<MovieRealm>(4)
                    movieRealm.json = json
                    movieRealm.lastUpdated = Date(System.currentTimeMillis()).time
                })
            }
        }
    }

}
package com.selfcompany.faizf.seemovie.data.repository.datasource.movielist

import android.content.Context
import com.selfcompany.faizf.seemovie.data.cache.realm.MovieListCache
import com.selfcompany.faizf.seemovie.domain.model.CategoryListMovie
import javax.inject.Inject

/**
 * Created by faizf on 07/03/2018.
 */
class MovieListDataStoreFactory @Inject constructor(private val movieListCache: MovieListCache,
                                                    private val context: Context) {

    fun create(isRefresh: Boolean, category: CategoryListMovie): MovieListDataStore {
      // return MovieListCloudDataStore(movieListCache, context, category)
        return if (isRefresh) {
            MovieListCloudDataStore(movieListCache, context, category)
        } else {
            if (!movieListCache.isExpired() && movieListCache.isCached()) {
                MovieListLocalDataStore(movieListCache, category)
            } else {
                MovieListCloudDataStore(movieListCache, context, category)
            }
        }
    }
}
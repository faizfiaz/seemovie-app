package com.selfcompany.faizf.seemovie.data.entity.movie

import com.selfcompany.faizf.newbase.entity.movie.MovieEntity

/**
 * Created by faizf on 16/03/2018.
 */

data class RecommendationMovieEntity(
		val page: Int,
		val results: List<MovieEntity>,
		val total_pages: Int,
		val total_results: Int
)
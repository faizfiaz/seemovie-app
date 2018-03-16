package com.selfcompany.faizf.seemovie.data.entity.movie

/**
 * Created by faizf on 16/03/2018.
 */

data class VideoMovieEntity(
		val id: Int,
		val results: List<ResultMovie>
)

data class ResultMovie(
		val id: String,
		val iso_639_1: String,
		val iso_3166_1: String,
		val key: String,
		val name: String,
		val site: String,
		val size: Int,
		val type: String
)
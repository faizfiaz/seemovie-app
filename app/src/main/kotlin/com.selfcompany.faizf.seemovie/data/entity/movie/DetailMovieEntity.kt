package com.selfcompany.faizf.seemovie.data.entity.movie

/**
 * Created by faizf on 10/03/2018.
 */
open class DetailMovieEntity (
		val adult: Boolean,
		val backdrop_path: String,
		val belongs_to_collection: Any,
		val budget: Int,
		val genres: List<Genre>,
		val homepage: String,
		val id: Int,
		val imdb_id: String,
		val original_language: String,
		val original_title: String,
		val overview: String,
		val popularity: Double,
		val poster_path: String,
		val production_companies: List<ProductionCompany>,
		val production_countries: List<ProductionCountry>,
		val release_date: String,
		val revenue: Int,
		val runtime: Int,
		val spoken_languages: List<SpokenLanguage>,
		val status: String,
		val tagline: String,
		val title: String,
		val video: Boolean,
		val vote_average: Double,
		val vote_count: Int
)

open class SpokenLanguage(
		val iso_639_1: String,
		val name: String
)

open class Genre(
		val id: Int,
		val name: String
)

open class ProductionCompany(
		val id: Int,
		val logo_path: Any,
		val name: String,
		val origin_country: String
)

open class ProductionCountry(
		val iso_3166_1: String,
		val name: String
)


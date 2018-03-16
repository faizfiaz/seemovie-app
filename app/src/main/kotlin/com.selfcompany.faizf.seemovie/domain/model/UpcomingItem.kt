package com.selfcompany.faizf.seemovie.domain.model

/**
 * Created by faizf on 10/03/2018.
 */
data class UpcomingItem(
        var id: Long,
        var title: String,
        var posterPath: String,
        var backdropPath: String,
        var popularity: Double,
        var genreIds: MutableList<Long>,
        var overview: String,
        var releaseDate: String,
        var voteAverage: Double,
        var voteCount: Int
)
package com.selfcompany.faizf.seemovie.domain.model

/**
 * Created by faizf on 07/03/2018.
 */
data class NowPlayingItem (
        var id: Long,
        var title: String,
        var posterPath: String,
        var backdropPath: String,
        var popularity: Double,
        var genreIds: MutableList<Long>,
        var overview: String
)
package com.selfcompany.faizf.newbase.entity.movie

/**
 * Created by faizf on 24/02/2018.
 */
open class MovieListEntity{

        var id: Long = 0

        lateinit var results: List<MovieEntity>

        var page: Long = 0

        var total_results: Long = 0

        var datesEntity: DatesEntity? = null

        var total_pages: Long = 0

        var last_updated: Long = 0
}



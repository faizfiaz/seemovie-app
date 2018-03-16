package com.selfcompany.faizf.newbase.entity.movie

import io.realm.RealmList
import io.realm.RealmObject

/**
 * Created by faizf on 22/02/2018.
 */
open class MovieEntity : RealmObject(){

        var ids: Long = 0

        var vote_count: Int = 0

        var id: Long = 0

        var video: Boolean = false

        var vote_average: Double = 0.0

        lateinit var title: String

        var popularity: Double = 0.0

        lateinit var poster_path: String

        lateinit var original_language: String

        lateinit var original_title: String

        lateinit var genre_ids: RealmList<Long>

        lateinit var backdrop_path: String

        var adult: Boolean = false

        lateinit var overview: String

        lateinit var release_date: String
}
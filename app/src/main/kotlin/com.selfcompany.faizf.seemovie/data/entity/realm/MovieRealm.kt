package com.selfcompany.faizf.seemovie.data.entity.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by faizf on 10/03/2018.
 */
open class MovieRealm(
    @PrimaryKey var id: Long = 0,
    var json: String = "",
    var lastUpdated: Long = 0
) : RealmObject(){

}
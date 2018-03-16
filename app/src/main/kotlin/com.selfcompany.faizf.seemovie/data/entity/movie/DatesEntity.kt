package com.selfcompany.faizf.newbase.entity.movie

import io.realm.RealmObject

/**
 * Created by faizf on 22/02/2018.
 */
open class DatesEntity: RealmObject(){
    lateinit var maximum: String
    lateinit var minimum: String
}
//data class DatesEntity(
//        var maximum: String,
//        var minimum: String
//) : RealmObject()
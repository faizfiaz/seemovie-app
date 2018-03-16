package com.selfcompany.faizf.seemovie.presentation.model.content

import android.support.v4.app.Fragment

/**
 * Created by faizf on 07/03/2018.
 */
open class ContentTab {

    var title: String? = null
    var imageId: Int = 0
    var fragment: Fragment? = null

    fun setTitle(title: String): ContentTab {
        this.title = title
        return this
    }

    fun setImageId(imageId: Int): ContentTab {
        this.imageId = imageId
        return this
    }

    fun setFragment(fragment: Fragment): ContentTab {
        this.fragment = fragment
        return this
    }
}

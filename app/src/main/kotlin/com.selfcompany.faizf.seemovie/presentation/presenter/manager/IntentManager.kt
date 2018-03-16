package com.selfcompany.faizf.newbase.manager

import android.content.Context
import javax.inject.Inject

/**
 * Created by faizf on 2/11/2017.
 */
class IntentManager @Inject constructor(private val context: Context) {

    interface Code {
        companion object {
            val FORM = 6001
            val REQUEST_CAMERA = 1
            val REQUEST_CAMERA_FARMER = 2
            val BACKGROUND = 1
            val BITMAP = 2
        }

    }
}

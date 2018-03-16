package com.selfcompany.faizf.newbase.base

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import com.selfcompany.faizf.newbase.utils.Util
import com.selfcompany.faizf.newbase.utils.UtilsLayout
import javax.inject.Inject

/**
 * Created by faizf on 2/8/2017.
 */
open class BaseActivity : AppCompatActivity() {

    @Inject lateinit var utilsLayout: UtilsLayout
    @Inject lateinit var util: Util

    protected var idFrame: Int = 0

    protected var progressDialog: ProgressDialog? = null


}

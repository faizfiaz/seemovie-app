package com.selfcompany.faizf.newbase.base

import android.app.ProgressDialog
import android.support.v4.app.Fragment
import com.selfcompany.faizf.newbase.utils.Util
import com.selfcompany.faizf.newbase.utils.UtilsLayout

/**
 * Created by faizf on 2/11/2017.
 */
open class BaseFragment : Fragment() {

    protected var idFrame: Int = 0

    protected var utilsLayout: UtilsLayout? = null
    protected var util: Util? = null

    protected var progressDialog: ProgressDialog? = null

}

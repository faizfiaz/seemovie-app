package com.selfcompany.faizf.newbase.utils

import android.app.Activity
import android.graphics.Point
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.FrameLayout
import com.selfcompany.faizf.newbase.manager.IntentManager
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * Created by faizf on 2/25/2017.
 */
class Util{

    @Inject lateinit var intentManager: IntentManager

    var VALIDATION_MAX24 = "Masukkan minimal 3 karakter"
    var VALIDATION_MINMAX13 = "Masukkan minimal 10 karakter"

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun setOneThirdLayout(activity:Activity): FrameLayout.LayoutParams {
        val display = activity.windowManager.defaultDisplay
        val size = Point()
        try {
            display?.getRealSize(size)
        } catch (err: NoSuchMethodError) {
            display?.getSize(size)
        }

        val height = size.y / 3
        return FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, height)
    }

//    fun showDialogError(context: Context, message: String) {
//        val builder = AlertDialog.Builder(context)
//        val alert = builder.create()
//        builder.setMessage(message)
//        builder.setCancelable(false)
//        //builder.setPositiveButton(context.resources.getString("try again")) { dialog, which -> alert.cancel() }
//        builder.show()
//    }
//
//    fun showExpired(context: Context) {
//        val builder = AlertDialog.Builder(context)
//        val alert = builder.create()
//        builder.setMessage(context.resources.getString(R.string.expired_session))
//        builder.setCancelable(false)
//        builder.setPositiveButton(context.resources.getString(R.string.login_again)) { dialog, which ->
//            //intentManager.toLogin();
//        }
//        builder.show()
//    }
//
//    fun showUnauthorized(context: Context) {
//        val builder = AlertDialog.Builder(context)
//        val alert = builder.create()
//        builder.setMessage(context.resources.getString(R.string.expired_session))
//        builder.setCancelable(false)
//        builder.setPositiveButton(context.resources.getString(R.string.login_again)) { dialog, which ->
//            //intentManager.toLogin();
//        }
//        builder.show()
//    }
//
//    fun validateEdittext(editText: EditText, lengthMin: Int, lengthMax: Int, error: String): Boolean {
//        if (editText.text.length < lengthMin || editText.text.length > lengthMax) {
//            editText.error = error
//            editText.requestFocus()
//            return false
//        } else {
//            return true
//        }
//    }
//
//
//    fun exitDialog(context: Activity) {
//        val builder = AlertDialog.Builder(context)
//        val alert = builder.create()
//        builder.setMessage(context.getString(R.string.prompt_exit))
//        builder.setCancelable(true)
//        builder.setNegativeButton(context.getString(R.string.yes)) { dialog, which -> context.finish() }
//        builder.setPositiveButton(context.getString(R.string.no)) { dialog, which -> alert.cancel() }
//        builder.show()
//    }

    companion object {

        var noSpecialChar = "^[\\w_\\s]+$"
        var address = "^[\\w\\s.]+$"
        var usernameRegex = "^[\\w_]+$"
        var inputForm = "^[\\w,\\s]+$"
        var onlyCharUnderScore = "^[a-zA-Z\\s]+$"
        var onlyDigits = "^\\d+$"

        internal val LOCATION = 0x1

        fun regexOnlyChar(character: String): Boolean {
            return regex(character, onlyCharUnderScore)
        }

        fun regexUsername(character: String): Boolean {
            return regex(character, usernameRegex)
        }


        fun regex(input: String, regex: String): Boolean {
            val pattern = Pattern.compile(regex)
            return pattern.matcher(input).matches()
        }
    }


}

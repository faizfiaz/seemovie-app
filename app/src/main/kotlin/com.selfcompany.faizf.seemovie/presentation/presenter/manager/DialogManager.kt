package com.selfcompany.faizf.newbase.manager

import android.content.Context
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog
import com.selfcompany.faizf.seemovie.R
import javax.inject.Inject


/**
 * Created by faizf on 4/27/2017.
 */
class DialogManager @Inject constructor(private val context: Context){

    fun loading(dialog : SweetAlertDialog) : SweetAlertDialog {
        dialog.progressHelper.barColor = R.color.colorPrimary
        dialog.progressHelper.rimColor = R.color.colorAccent
        dialog.titleText = "Loading"
        dialog.setCancelable(false)
        if (!dialog.isShowing) {
            dialog.show()
        }else{
            dialog.dismissWithAnimation()
            dialog.show()
        }
        return dialog
    }

    fun error(dialog : SweetAlertDialog) : SweetAlertDialog {
        dialog.titleText = "Oopps..."
        dialog.contentText = "Something went wrong"
        dialog.setCustomImage(R.drawable.ic_cinema)
        dialog.confirmText = "Try Again"
        dialog.setCancelable(false)
        if (!dialog.isShowing) {
            dialog.show()
        }else{
            dialog.dismissWithAnimation()
            dialog.show()
        }
        return dialog
    }

}

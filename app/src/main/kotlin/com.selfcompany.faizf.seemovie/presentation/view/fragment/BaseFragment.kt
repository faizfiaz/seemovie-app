package com.selfcompany.faizf.seemovie.presentation.view.fragment

import android.support.v4.app.Fragment
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog
import com.selfcompany.faizf.newbase.manager.DialogManager
import com.selfcompany.faizf.newbase.utils.Util
import javax.inject.Inject

/**
 * Created by faizf on 08/03/2018.
 */
open class BaseFragment : Fragment() {
    @Inject lateinit var dialogManager: DialogManager
    @Inject lateinit var util: Util
    protected lateinit var dialog: SweetAlertDialog

    fun createLoading(){
        dialog = SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE)
        dialogManager.loading(dialog)
    }

    fun createErrorTimeout(){
        dialog = SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
        dialogManager.error(dialog)
    }

    fun dismissLoading() {
        dialog.dismissWithAnimation()
    }
}
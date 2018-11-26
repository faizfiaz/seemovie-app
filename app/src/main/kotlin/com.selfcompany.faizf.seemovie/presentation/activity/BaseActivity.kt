package com.selfcompany.faizf.seemovie.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog
import com.selfcompany.faizf.newbase.manager.DialogManager
import javax.inject.Inject

/**
 * Created by faizf on 08/03/2018.
 */
open class BaseActivity : AppCompatActivity() {

    @Inject lateinit var dialogManager: DialogManager
    protected lateinit var dialog: SweetAlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onStop() {
        super.onStop()
        this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun createLoading(){
        dialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
        dialogManager.loading(dialog)
    }

    fun createErrorTimeout(){
        dialog = SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
        dialogManager.error(dialog)
    }

    fun dismissLoading() {
        dialog.dismissWithAnimation()
    }
}
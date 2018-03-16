package com.selfcompany.faizf.newbase.utils

import android.app.Activity
import com.selfcompany.faizf.newbase.manager.IntentManager
import dagger.Module
import javax.inject.Inject

/**
 * Created by faizf on 7/11/2017.
 */
@Module
class UtilsCodeCheck {

    @Inject
    lateinit var activity: Activity
    @Inject
    lateinit var intentManager: IntentManager
    @Inject
    lateinit var util: Util

//    fun <E> checkCodeGet(callbackConnection: CallbackConnection, o: Response<E>, progressDialog: ProgressDialog) {
//        when (o.code()) {
//            200 -> callbackConnection.onSuccess(o.body())
//            203 -> showNotMatch<Any>(o)
//            204 -> callbackConnection.onSuccessNull()
//            403 -> util!!.showExpired(activity)
//            400 -> showErrorValidate<Any>(o)
//            409 -> util!!.showUnauthorized(activity)
//            else -> showError<Any>(o)
//        }
//        progressDialog.dismiss()
//    }
//
//    fun <E> showNotMatch(o: Response<E>) {
//        //        ModelError modelError = null;
//        //        modelError = new Gson().fromJson(String.valueOf(o.body()), ModelError.class);
//        util!!.showDialogError(activity, "Terjadi kesalahan harap hubungi admin")
//    }
//
//    fun <E> showError(o: Response<E>) {
//        //        ModelError modelError = null;
//        //        try {
//        //            modelError = new Gson().fromJson(o.errorBody().string(), ModelError.class);
//        //        } catch (IOException e) {
//        //            e.printStackTrace();
//        //        }
//        //        util.showDialogError(activity, modelError.getMessage());
//    }
//
//    private fun <E> showErrorValidate(o: Response<E>) {
//        //        ModelError modelError = null;
//        //        String error = "";
//        //
//        //        try {
//        //            modelError = new Gson().fromJson(o.errorBody().string(), ModelError.class);
//        //            if (modelError.getErrors() != null) {
//        //                for (int i = 0; i < modelError.getErrors().length; i++) {
//        //                    error = error + "- " + modelError.getErrors()[i] + "\n";
//        //                }
//        //            }
//        //        } catch (IOException e) {
//        //            e.printStackTrace();
//        //        }
//        //        util.showDialogError(activity, modelError.getMessage() + ":\n\n" + error);
//    }


}

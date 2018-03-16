package com.selfcompany.faizf.newbase.utils

import android.widget.EditText
import android.widget.TextView
import dagger.Module

/**
 * Created by faizf on 2/10/2017.
 */
@Module
class UtilsLayout {
    fun getBodyText(textView: TextView): String {
        return textView.text.toString()
    }

    fun getText(editText: EditText): String {
        return editText.text.toString()
    }
}

package com.selfcompany.faizf.newbase.repository.session

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by faizf on 6/5/2017.
 */

class SessionToken(context: Context) {
    private val PREF_NAME = "token"
    private val KEY_NAME = "authToken"

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    var token: String
        get() = this.sharedPreferences.getString(KEY_NAME, "kosong")
        set(token) {
            if (token != null) clear()
            this.editor.putString(KEY_NAME, token)
            this.editor.commit()
        }

    init {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        this.editor = sharedPreferences.edit()
    }

    fun clear() {
        this.editor.clear()
        this.editor.commit()
    }
}

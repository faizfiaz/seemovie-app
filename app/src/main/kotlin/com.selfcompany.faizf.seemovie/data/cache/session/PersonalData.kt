package com.selfcompany.faizf.newbase.repository.session

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by faizf on 2/11/2017.
 */

class PersonalData(context: Context) {
    private val PREF_NAME = "personaldata"
    private val NAME_USER = "username"
    private val PROF_PIC = "prof_pic"
    private val TEAM = "team"
    private val ID = "idUser"
    private val USER_ID = "userId"

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    var nameUser: String?
        get() = this.sharedPreferences.getString(NAME_USER, null)
        set(nameUser) {
            if (nameUser != null) clear()
            this.editor.putString(NAME_USER, nameUser)
            this.editor.commit()
        }

    var profPic: String?
        get() = this.sharedPreferences.getString(PROF_PIC, null)
        set(profPic) {
            this.editor.putString(PROF_PIC, profPic)
            this.editor.commit()
        }

    var userId: Long
        get() = this.sharedPreferences.getLong(USER_ID, 0)
        set(userId) {
            this.editor.putLong(USER_ID, userId)
            this.editor.commit()
        }

    var team: String?
        get() = this.sharedPreferences.getString(TEAM, null)
        set(team) {
            this.editor.putString(TEAM, team)
            this.editor.commit()
        }

    var id: Long
        get() = this.sharedPreferences.getLong(ID, 0)
        set(id) {
            this.editor.putLong(ID, id)
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

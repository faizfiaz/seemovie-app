package com.selfcompany.faizf.newbase.utils

import android.widget.EditText
import java.util.regex.Pattern

/**
 * Created by faizf on 4/13/2017.
 */

object Validation {
    private val EMAIL_ERROR = "Insert Valid Email"
    private val INPUT_ERROR = "This Field Must Be Filled"
    private val PASSWORD_ERROR = "This Field Must Be Filled minimum 6 character"
    private val MIN_ERROR = "This Field Must Be Filled minimum "
    private val CHAR = " character"
    private val PASSWORD_NOT_SAME = "Your password doesn't match"

    fun checkEmail(editText: EditText): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val inputStr = editText.text.toString()
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(inputStr)
        if (editText.text.toString() == "" && editText.text.length == 0) {
            editText.error = INPUT_ERROR
            return false
        } else {
            if (matcher.matches()) {
                return true
            } else {
                editText.error = EMAIL_ERROR
                editText.requestFocus()
                return false
            }

        }


    }

    fun checkPassword(editText: EditText): Boolean {
        if (editText.text.toString() == "" || editText.text.length < 6) {
            editText.error = PASSWORD_ERROR
            editText.requestFocus()
            return false
        } else {
            return true
        }
    }

    fun checkEdittext(editText: EditText): Boolean {
        if (editText.text.toString() == "" && editText.text.length == 0) {
            editText.error = INPUT_ERROR
            editText.requestFocus()
            return false
        } else {
            return true
        }
    }

    fun checkEdittextMin(editText: EditText, min: Int): Boolean {
        if (editText.text.toString() == "" || editText.text.length < min) {
            editText.error = MIN_ERROR + min.toString() + CHAR
            editText.requestFocus()
            return false
        } else {
            return true
        }
    }

    fun checkPasswordSame(password: EditText, passwordConfirm: EditText): Boolean {
        if (password.text.toString() != passwordConfirm.text.toString()) {
            passwordConfirm.error = PASSWORD_NOT_SAME
            passwordConfirm.requestFocus()
            return false
        } else {
            return true
        }
    }
}

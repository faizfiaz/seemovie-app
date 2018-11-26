package com.selfcompany.faizf.newbase.utils

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText

import java.text.DecimalFormatSymbols

/**
 * Created by AndreHF on 6/15/2016.
 */
object FormatterDecimal {
    private var decimalFormat: java.text.DecimalFormat? = null

    /*
    public static String decimalFormat(Number text) {
        if (text != null) {
            return new String().format("%,.2f", text);
        }
        return null;
    }
*/

    private fun makeFormatter() {
        val decimalFormatSymbols = DecimalFormatSymbols()
        decimalFormatSymbols.groupingSeparator = '.'
        decimalFormat = java.text.DecimalFormat("#,##0", decimalFormatSymbols)
    }

    fun decimalFormat(data: Number): String {
        makeFormatter()
        return decimalFormat!!.format(data)
    }


    fun wordsCapitalize(targetET: EditText) {
        targetET.addTextChangedListener(object : TextWatcher {
            internal var mStart = 0

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mStart = start + count
            }

            override fun afterTextChanged(s: Editable) {
                val input = s.toString()
                var capitalizedText: String

                if (input.length < 1)
                    capitalizedText = input
                else {
                    val words = input.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    val containSpace = input[input.length - 1] == ' '
                    for (i in words.indices) {
                        val capitalizedWord = words[i].substring(0, 1).toUpperCase() + words[i].substring(1)
                        words[i] = capitalizedWord
                    }
                    capitalizedText = TextUtils.join(" ", words)
                    if (containSpace)
                        capitalizedText += " "
                }
                if (capitalizedText != targetET.text.toString()) {
                    targetET.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                        }

                        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                        }

                        override fun afterTextChanged(s: Editable) {
                            targetET.setSelection(mStart)
                            targetET.removeTextChangedListener(this)
                        }
                    })
                    targetET.setText(capitalizedText)
                }
            }
        })
    }
}

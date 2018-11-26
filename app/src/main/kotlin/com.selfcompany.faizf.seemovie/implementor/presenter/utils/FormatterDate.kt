package com.selfcompany.faizf.seemovie.implementor.presenter.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by AndreHF on 10/25/2016.
 */

class FormatterDate {
    val format = SimpleDateFormat("E MMM DD HH:mm:ss zzz yyyy")
    val formatWithTime = SimpleDateFormat("yyyy-MM-dd")
    val formatDate = SimpleDateFormat("dd-MMMM-yyyy", Locale("in"))


    fun changeDate(sDate: String?): String {
        var result = ""
        if (sDate != null) {
            try {
                val date = formatWithTime.parse(sDate)
                result = formatDate.format(date).replace("-".toRegex(), " ")
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }
        return result
    }


    fun changeDateFormat(sDate: String?): String {
        var result = ""
        if (sDate != null) {
            try {
                val date = format.parse(sDate)
                result = formatDate.format(date).replace("-".toRegex(), " ")
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }
        return result
    }

    fun dateToLong(sDate: String): Long {
        try {
            val d = formatDate.parse(sDate)
            return d.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return 0
    }


    fun formatDate(date: Long): String {
        return format.format(Date(date))
    }

    fun formatDate(date: Long, format: String): String {
        val formatDate = SimpleDateFormat(format,
                Locale("in"))
        return formatDate.format(Date(date))
    }

}

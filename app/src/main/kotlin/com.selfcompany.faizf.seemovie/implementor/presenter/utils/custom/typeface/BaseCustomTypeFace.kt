package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.MetricAffectingSpan
import com.selfcompany.faizf.newbase.utils.ReadFont


open class BaseCustomTypeFace(context: Context) : MetricAffectingSpan() {
    protected var readFont: ReadFont
    protected var typeface: Typeface? = null

    init {
        readFont = ReadFont(context)
    }


    override fun updateMeasureState(p: TextPaint) {
        p.typeface = typeface
        p.flags = p.flags or Paint.SUBPIXEL_TEXT_FLAG
    }

    override fun updateDrawState(tp: TextPaint) {
        tp.typeface = typeface
        tp.flags = tp.flags or Paint.SUBPIXEL_TEXT_FLAG

    }
}

package com.selfcompany.faizf.newbase.utils.custom.textview

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.widget.TextView
import com.selfcompany.faizf.newbase.utils.ReadFont

class CustomTextViewRegular : TextView {
    private var readFont: ReadFont? = null

    constructor(context: Context) : super(context) {
        setFont(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setFont(context)

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setFont(context)

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        setFont(context)

    }


    protected fun setFont(context: Context) {
        readFont = ReadFont(context)
        typeface = readFont!!.regular()
    }


}

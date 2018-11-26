package com.selfcompany.faizf.newbase.utils.custom.edittext

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.widget.EditText
import com.selfcompany.faizf.newbase.utils.ReadFont

class CustomEditTextRegular : EditText {
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

package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context

class CustomTypeFaceBoldItalic(context: Context) : BaseCustomTypeFace(context) {
    init {
        typeface = readFont.boldItalic()
    }
}

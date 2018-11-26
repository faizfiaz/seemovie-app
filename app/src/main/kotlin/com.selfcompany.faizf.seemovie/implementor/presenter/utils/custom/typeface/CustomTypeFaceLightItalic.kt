package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context


class CustomTypeFaceLightItalic(context: Context) : BaseCustomTypeFace(context) {
    init {
        typeface = readFont.lightItalic()
    }
}

package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context


class CustomTypeFaceItalic(context: Context) : BaseCustomTypeFace(context) {
    init {
        typeface = readFont.italic()
    }
}

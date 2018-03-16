package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context


class CustomTypeFaceLight(context: Context) : BaseCustomTypeFace(context) {
    init {
        typeface = readFont.light()
    }
}

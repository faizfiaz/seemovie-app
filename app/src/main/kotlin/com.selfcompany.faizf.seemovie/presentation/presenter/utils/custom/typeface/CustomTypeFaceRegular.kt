package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context


class CustomTypeFaceRegular(context: Context) : BaseCustomTypeFace(context) {
    init {
        typeface = readFont.regular()
    }
}

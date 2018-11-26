package com.selfcompany.faizf.newbase.utils.custom.typeface

import android.content.Context


class CustomTypeFaceBold(context: Context) : BaseCustomTypeFace(context) {
    init {
        typeface = readFont.bold()
    }
}

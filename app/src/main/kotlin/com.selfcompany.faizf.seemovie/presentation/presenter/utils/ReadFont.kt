package com.selfcompany.faizf.newbase.utils

import android.content.Context
import android.graphics.Typeface

class ReadFont(private val context: Context) {
    internal var fontName: String? = null

    fun bold(): Typeface {
        return font("Lato-Bold.ttf")
    }

    fun boldItalic(): Typeface {
        return font("Lato-BoldItalic.ttf")
    }

    fun italic(): Typeface {
        return font("Lato-Italic.ttf")
    }

    fun light(): Typeface {
        return font("Lato-Light.ttf")
    }

    fun lightItalic(): Typeface {
        return font("Lato-LightItalic.ttf")
    }

    fun regular(): Typeface {
        return font("Lato-Regular.ttf")
    }


    private fun font(fontName: String): Typeface {
        return Typeface.createFromAsset(context.assets, "fonts/" + fontName)
    }
}

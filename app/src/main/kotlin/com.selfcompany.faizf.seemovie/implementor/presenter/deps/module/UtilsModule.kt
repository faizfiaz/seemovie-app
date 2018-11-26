package com.selfcompany.faizf.seemovie.implementor.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.newbase.utils.PermissionMarshmellow
import com.selfcompany.faizf.newbase.utils.Util
import com.selfcompany.faizf.seemovie.implementor.presenter.utils.FormatterDate
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 07/03/2018.
 */
@Module
class UtilsModule(context: Context) {

    private val context = context

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun providesPermissionMarshmellow(context: Context): PermissionMarshmellow {
        return PermissionMarshmellow(context)
    }

    @Provides
    @Singleton
    fun provideUtils(): Util {
        return Util()
    }

    @Provides
    @Singleton
    fun provideFormatterDate(): FormatterDate {
        return FormatterDate()
    }


}
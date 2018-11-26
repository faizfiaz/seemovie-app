package com.selfcompany.faizf.seemovie.implementor.presenter.deps.module

import android.content.Context
import com.selfcompany.faizf.newbase.manager.DialogManager
import com.selfcompany.faizf.newbase.manager.IntentManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by faizf on 08/03/2018.
 */
@Module
class ManagerModule{

    @Provides
    @Singleton
    fun providesIntentManager(context: Context): IntentManager {
        return IntentManager(context)
    }

    @Provides
    @Singleton
    fun providesDialogManager(context: Context): DialogManager{
        return DialogManager(context)
    }
}
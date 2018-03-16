package com.selfcompany.faizf.seemovie

import android.app.Application
import com.selfcompany.faizf.seemovie.presentation.presenter.deps.components.DaggerAppComponents
import com.selfcompany.faizf.seemovie.presentation.presenter.deps.module.*
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by faizf on 07/03/2018.
 */
class SeeMovieApp : Application() {

    private var mainApp: SeeMovieApp? = null
    private var config: RealmConfiguration? = null
    private var realm: Realm? = null

    override fun onCreate() {
        super.onCreate()
        mainApp = this

        //Realm init
        Realm.init(this)
        config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)

    }

    val injector by lazy {
        DaggerAppComponents.builder()
                .utilsModule(UtilsModule(this))
                .presenterModule(PresenterModule())
                .repositoryModule(RepositoryModule())
                .cacheModule(CacheModule())
                .factoryModule(FactoryModule())
                .mapperModule(MapperModule())
                .managerModule(ManagerModule())
                .build()
    }


}
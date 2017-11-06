package com.qg.gankio

import android.app.Application
import com.mobile.utils.Utils
import com.qg.gankio.api.GankApi
import com.qg.gankio.di.Component.DaggerAppComponent
import com.qg.gankio.di.module.AppModule
import javax.inject.Inject

/**
 * Created by jimji on 2017/11/6.
 */
class App : Application() {
    lateinit var apiService: GankApi
        @Inject set

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        injectApi()
    }

    private fun injectApi() {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                .inject(this)
    }
}
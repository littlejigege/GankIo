package com.qg.gankio.di.Component

import com.qg.gankio.App
import com.qg.gankio.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jimji on 2017/11/6.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
}
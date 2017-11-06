package com.qg.gankio.di.module

import com.mobile.utils.Utils
import com.qg.gankio.App
import com.qg.gankio.api.GankApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by jimji on 2017/11/6.
 */
@Module
class AppModule(app: App) {
    init {
        Utils.init(app)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://gank.io/api/")
                .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): GankApi {
        return retrofit.create(GankApi::class.java)
    }



}
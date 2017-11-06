package com.qg.gankio.api

import com.qg.gankio.model.Feedback
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by jimji on 2017/11/6.
 */
interface GankApi {
    @GET("day/{year}/{month}/{day}")
    fun getOneDayList(@Path("year") year: Int, @Path("month") month: Int, @Path("day") day: Int): Observable<Feedback>
}
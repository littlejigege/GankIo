package com.qg.gankio.model

import com.google.gson.annotations.SerializedName

/**
 * Created by jimji on 2017/11/6.
 */
data class Article(var desc: String, @SerializedName("images") var imageUrls: List<String>?, var url: String)

data class Result(@SerializedName("Android") var androidList: List<Article>)

data class Feedback(@SerializedName("results") var data: Result)
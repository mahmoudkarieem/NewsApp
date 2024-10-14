package com.example.newsapp.data.remote.api

import com.example.newsapp.utli.Utils.API_KEY
import com.example.newsapp.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNews {

    @GET("everything")
    fun getNews(
        @Query("sources") sources:String,
        @Query("page") page:Int,
        @Query("apiKey") apiKey:String=API_KEY
    ):NewsResponse
}
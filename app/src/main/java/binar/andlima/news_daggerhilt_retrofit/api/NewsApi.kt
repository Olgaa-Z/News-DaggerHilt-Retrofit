package binar.andlima.news_daggerhilt_retrofit.api

import binar.andlima.news_daggerhilt_retrofit.model.ResponseNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {

    @GET("news")
    suspend fun getAllNews(): List<ResponseNewsItem>
}
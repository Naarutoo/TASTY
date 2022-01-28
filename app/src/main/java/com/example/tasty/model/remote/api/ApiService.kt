package com.example.tasty.model.remote.api

import com.example.tasty.model.remote.api.response.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("feeds/list")
    suspend fun getData(
        @Query("size") size: Int = 20,
        @Query("timezone") timezone: String = "+0700",
        @Query("vegetarian") vegetarian: Boolean = false,
        @Query("from") from: Int = 0
    ): ResponseDTO
}
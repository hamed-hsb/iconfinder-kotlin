package com.hsb.iconfinder_kotlin.data.remote

import com.hsb.iconfinder_kotlin.domain.model.IconFinder
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService  {

   // ?query=arrow&count=10
    @POST("?")
    suspend fun getSearchIcon(@Query("query") query: String,@Query("count") count: Int) : IconFinder
}
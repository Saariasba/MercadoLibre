package com.santi.mercadolibre.api

import com.santi.mercadolibre.models.ProductResponse
import com.santi.mercadolibre.models.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/sites/MCO/search")
    suspend fun getSearch(@Query("q") keyword: String): Response<SearchResponse>

    @GET("/items/{id}")
    suspend fun getProduct(@Path("id") id: String): Response<ProductResponse>
}